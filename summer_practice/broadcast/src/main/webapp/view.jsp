<html>
<head>
  <title>Echo Chamber</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width">
  <script src="../../../../conference/src/main/webapp/resources/js/webrtcviewer.js"></script>
</head>
<body>

<div>
  <video id="vid1" style="width: 400px"></video>
</div>
<div>
  <button type="button" onclick="connect()" >Open</button>
</div>


<!-- Script to utilise the WebSocket -->
<script type="text/javascript">
  function connect(){
    WebRtcViewer(document.getElementById("vid1"),new WebSocket("ws://localhost:8080/broadcast/rtc"), "1");
  }
</script>

</body>
</html>