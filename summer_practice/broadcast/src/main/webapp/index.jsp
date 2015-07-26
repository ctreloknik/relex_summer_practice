<html>
<head>
    <title>Echo Chamber</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <script src="../../../../conference/src/main/webapp/resources/js/webrtcbroadcast.js"></script>
</head>
<body>

<div>
    <video id="vid1" style="width: 400px"></video>
</div>
<div>
    <button type="button" onclick="openSocket();" >Open</button>
</div>


<!-- Script to utilise the WebSocket -->
<script type="text/javascript">

    var stream;

    vid1 = document.getElementById("vid1");
    var wrb = undefined;

    function openSocket(){
        navigator.webkitGetUserMedia({
            audio : true,
            video : true
        }, function(s) {
            stream = s;
            vid1.src = URL.createObjectURL(s);
            vid1.play();
            WebRtcBroadcast(stream, new WebSocket("ws://localhost:8080/broadcast/rtc"), "1");
        }, function(error) {
            try {
                console.error(error);
            } catch (e) {
            }
        });
    }
</script>

</body>
</html>