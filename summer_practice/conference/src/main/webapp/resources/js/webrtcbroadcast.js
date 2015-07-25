var webSocket = undefined;
var stream = undefined;
var room_id = undefined;
var session_id = undefined;
var pcs = []

configuration = {
    "iceServers" : [ {
        "url" : "stun:stun.l.google.com:19302"
    } ]
};

mediaOffenerConstraints = {
    'mandatory' : {
        'OfferToReceiveAudio' : false,
        'OfferToReceiveVideo' : false
    }
};

function WebRtcBroadcast(str, ws, room){
    webSocket = ws;
    stream = str;
    room_id = room;

    webSocket.onmessage = function(message){
        var msg = JSON.parse(message.data);
        switch (msg.type) {
            case 'session_id':
                session_id = msg.data;
                webSocket.send(JSON.stringify({
                    type: "streamer",
                    room: room_id
                }));
                break;
            case 'offer':
                pcs[msg.viewer] = new webkitRTCPeerConnection(this.configuration);
                pcs[msg.viewer].addStream(stream);
                pcs[msg.viewer].onicecandidate = function(e) {
                    if (e.candidate) {
                        webSocket.send(JSON.stringify({
                            type : 'answer_candidate',
                            data : {
                                label : e.candidate.sdpMLineIndex,
                                id : e.candidate.sdpMid,
                                candidate : e.candidate.candidate
                            },
                            room: room_id,
                            viewer: msg.viewer
                        }));
                    }
                };

                pcs[msg.viewer].setRemoteDescription(new RTCSessionDescription(msg.data));
                pcs[msg.viewer].createAnswer(function(description) {
                    pcs[msg.viewer].setLocalDescription(description);
                    webSocket.send(JSON.stringify({
                        type : 'answer',
                        data : description,
                        room: room_id,
                        viewer: msg.viewer
                    }));
                }, null, mediaOffenerConstraints);
                break;
            case 'offer_candidate':
                var candidate = new RTCIceCandidate({
                    sdpMLineIndex : msg.data.label,
                    candidate : msg.data.candidate
                });
                pcs[msg.viewer].addIceCandidate(candidate);
                break;
            case 'disconnect_viewer':
                pcs[msg.viewer].close();
                pcs.splice(msg.viewer,1);
                break;
        }
    }

    webSocket.onopen = function(){
        webSocket.send(JSON.stringify({
            type: "start_stream",
            room: room_id
        }));
    }
}
