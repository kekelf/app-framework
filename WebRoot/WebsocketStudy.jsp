<!DOCTYPE html>
<html>
<head>
    <title>Testing websockets</title>
    <meta charset="utf-8">
</head>
<body>
<div>
    <input type="submit" value="Start" onclick="start()" />
</div>
<div id="messages"></div>
<script type="text/javascript">
    var webSocket = new WebSocket('ws://localhost:80/app-framework/websocket');

    webSocket.onerror = function(event) {
        onError(event)
    };

    webSocket.onopen = function(event) {
        console.log("WEBSOCKET XXXX");
        onOpen(event)
    };

    webSocket.onmessage = function(event) {
        onMessage(event)
    };

    function onMessage(event) {
        document.getElementById('messages').innerHTML
                += '<br />' + event.data;
    }

    function onOpen(event) {
        document.getElementById('messages').innerHTML
                = 'Connection established';
    }

    function onError(event) {
        alert(event.data);
    }

    function start() {
        webSocket.send('hello');
        return false;
    }
</script>
</body>
</html>