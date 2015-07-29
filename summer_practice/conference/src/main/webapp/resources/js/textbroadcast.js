var person_id = undefined;
var lecture_id = undefined;
var socket = undefined;


function TextBroadcast(lecture, person, ws){

    person_id = person;
    lecture_id = lecture;
    socket = ws;

    socket.onmessage = function(message){
        var msg = JSON.parse(message.data);
        switch (msg.type) {
            case 'new_question':
                var element = '<div id="question'+msg.question+'"><strong>';
                element+= msg.name;
                element+='</strong><div class="clearfix">';
                element+=msg.text;
                element+='</div><div class="clearfix"><small><span class="glyphicon glyphicon-time"></span> ';
                element+=msg.datetime;
                element+='</small>';
                element+='<button class="btn btn-success btn-xs glyphicon glyphicon-thumbs-up pull-right" id="moder';
                element+=msg.question;
                element+='"></button>';
                element+='<button class="btn btn-danger btn-xs glyphicon glyphicon-thumbs-down pull-right" id="unmoder';
                element+=msg.question+'"></button></div>';
                element+='<hr></hr></div>';
                $("#moder-text").append(element);
                $("#moder"+msg.question).on("click", function(){
                    socket.send(JSON.stringify({
                        type: "moder",
                        lecture: msg.lecture,
                        question: msg.question
                    }));
                    $("#question"+msg.question).remove();
                });
                $("#unmoder"+msg.question).on("click", function(){
                    socket.send(JSON.stringify({
                        type: "unmoder",
                        lecture: msg.lecture,
                        question: msg.question
                    }));
                    $("#question"+msg.question).remove();
                });
                break;
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

    socket.onopen = function(){
        socket.send(JSON.stringify({
            type: "moderator",
            lecture: lecture_id
        }));
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

function moder(lecture, question){
    socket.send(JSON.stringify({
        type: "moder",
        lecture: lecture,
        question: question
    }));
    $("#question"+question).remove();
}

function unmoder(lecture, question){
    socket.send(JSON.stringify({
        type: "unmoder",
        lecture: lecture,
        question: question
    }));
    $("#question"+question).remove();
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

function dislike(lecture, question, person){
    socket.send(JSON.stringify({
        type: "rating",
        lecture: lecture,
        question: question,
        person: person,
        rating: -1
    }));
}

function sendQuestion(message){
    socket.send(JSON.stringify({
        type: "new_question",
        lecture: lecture_id,
        text: message
    }));
}

function sendMessage(message, lecture){
    socket.send(JSON.stringify({
        type: "message",
        lecture: lecture,
        text: message
    }));
}

window.addEventListener("beforeunload", function(evt){
    socket.send(JSON.stringify({
        type : 'disconnect_moderator',
        lecture: lecture_id
    }));
    webSocket.close();
    pc.close();
}, true);