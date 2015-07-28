var room_id = undefined;
var session_id = undefined;
var webSocket = undefined;
var PeerConnection = window.mozRTCPeerConnection || window.webkitRTCPeerConnection;
navigator.getUserMedia = navigator.getUserMedia || navigator.mozGetUserMedia || navigator.webkitGetUserMedia;
var IceCandidate = window.mozRTCIceCandidate || window.RTCIceCandidate;
var SessionDescription = window.mozRTCSessionDescription || window.RTCSessionDescription;

var server = {
    iceServers: [
        {url: "stun:stun.l.google.com:19302"},
        {url: "stun:stun.services.mozilla.com"}
    ]
}

var options = {
    optional: [
        {DtlsSrtpKeyAgreement: true},
        {RtpDataChannels: true}
    ]
}

function WebRtcViewer(video, ws, room){
    webSocket = ws;
    room_id = room;
    this.configuration = {
        "iceServers" : [ {
            "url" : "stun:stun.l.google.com:19302"
        } ]
    };

    this.pc = new PeerConnection(server,options);

    this.mediaConstraints = {
        'mandatory' : {
            'OfferToReceiveAudio' : true,
            'OfferToReceiveVideo' : true
        }
    };

    pc.onicecandidate = function(e) {
        if (e.candidate) {
            webSocket.send(JSON.stringify({
                type : 'offer_candidate',
                data : {
                    label : e.candidate.sdpMLineIndex,
                    id : e.candidate.sdpMid,
                    candidate : e.candidate.candidate,
                },
                room: room_id,
                viewer: session_id
            }));
        }
    };

    pc.onaddstream = function(e) {
        video.src = URL.createObjectURL(e.stream);
        video.play();
    };


    this.webSocket.onmessage = function(message)
    {
        var msg = JSON.parse(message.data);

        switch (msg.type) {
            case 'session_id':
                session_id = msg.data;
                webSocket.send(JSON.stringify({
                    type: "viewer",
                    viewer: session_id,
                    room: room_id
                }));
                break;
            case 'answer':
                pc.setRemoteDescription(new SessionDescription(msg.data));
                break;
            case 'start_stream':
                pc.createOffer(function(description) {
                    pc.setLocalDescription(description);
                    webSocket.send(JSON.stringify({
                        type : 'offer',
                        data : description,
                        room: room_id,
                        viewer: session_id
                    }));
                }, null, mediaConstraints);
                break;
            case 'answer_candidate':
                var candidate = new IceCandidate({
                    sdpMLineIndex : msg.data.label,
                    candidate : msg.data.candidate
                });
                pc.addIceCandidate(candidate);
                break;
            case 'end_stream':
                video.stop();
                pc.close();
                break;
        }
    }
}

window.addEventListener("beforeunload", function(evt){
    webSocket.send(JSON.stringify({
        type : 'disconnect_viewer',
        room: room_id,
        viewer: session_id
    }));
    webSocket.close();
    pc.close();
}, true);

