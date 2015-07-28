var person_id = undefined;
var lecture_id = undefined;
var socket = undefined;

function TextViewer(lecture, person, ws, btn){

    person_id = person;
    lecture_id = lecture;
    socket = ws;

    socket.onmessage = function(message){
        var msg = JSON.parse(message.data);
        switch (msg.type) {
            case 'start_stream':
                btn.disabled = false;
                break
            case 'moder_question':
                addQuestion(msg);
                break;
            case 'rating':
                $("#r"+msg.question).text(msg.rating);
                break;
            case 'message':
                addMessage(msg);
                break;
        }
    }

    function addQuestion(msg){
        var element = '<div><strong><small>';
        element+=msg.name;
        element+='</small><span class="badge pull-right" id="r'+msg.question+'">';
        element+=msg.rating;
        element+='</span></strong><div class="clearfix"><small>';
        element+=msg.text;
        element+='</small></div><div class="clearfix"><small><span class="glyphicon glyphicon-time"></span>';
        element+=' '+msg.datetime;
        element+='</small><button class="btn btn-success btn-xs glyphicon glyphicon-thumbs-up pull-right" id="ql';
        element+=msg.question;
        element+='"></button>';
        element+='<button class="btn btn-danger btn-xs glyphicon glyphicon-thumbs-down pull-right" id="qd';
        element+=msg.question;
        element+='"></button>';
        element+='</div><hr></hr></div>';
        $("#question-text").prepend(element);
        $("#ql"+msg.question).on("click", function() {
            socket.send(JSON.stringify({
                type: "rating",
                lecture: msg.lecture,
                question: msg.question,
                person: person,
                rating: +1
            }));
        });
        $("#qd"+msg.question).on("click", function() {
            socket.send(JSON.stringify({
                type: "rating",
                lecture: msg.lecture,
                question: msg.question,
                person: person,
                rating: -1
            }));
        });
    }


    socket.onopen = function(){
        socket.send(JSON.stringify({
            type: "viewer",
            lecture: lecture_id,
            person: person_id
        }));
    }

}

function addMessage(msg){
    var element = "<small><span class='glyphicon glyphicon-time'></span>";
    element +=' ' + msg.datetime;
    element += "</small>";
    element += "<p>";
    element += msg.text;
    element += "</p>";
    element += '<hr></hr>';
    $("#msg-text").append(element);
}



function like(lecture, question, person){
    socket.send(JSON.stringify({
        type: "rating",
        lecture: lecture,
        question: question,
        person: person,
        rating: 1
    }));
}

function dislike(lecture, question, person){
    socket.send(JSON.stringify({
        type: "rating",
        lecture: lecture,
        question: question,
        person: person,
        rating: -1
    }));
}
function sendQuestion(question){
    socket.send(JSON.stringify({
        type: "new_question",
        lecture: lecture_id,
        person: person_id,
        text: question
    }));
}

function sendMessage(message){
    socket.send(JSON.stringify({
        type: "message",
        lecture: lecture_id,
        text: message
    }));
}

window.addEventListener("beforeunload", function(evt){
    socket.send(JSON.stringify({
        type : 'disconnect_viewer',
        lecture: lecture_id,
        person: person_id
    }));
    webSocket.close();
    pc.close();
}, true);