// Create a WebSocket connection. Replace with your hostname
var ws = new SockJS("https://blue-horse.rmq.cloudamqp.com/stomp");
var client = Stomp.over(ws);

// RabbitMQ Web-Stomp does not support heartbeats so disable them
client.heartbeat.outgoing = 0;
client.heartbeat.incoming = 0;

client.debug = onDebug;

// Make sure the user has limited access rights
client.connect("webstomp-user", "webstomp-password", onConnect, onError, "vhost");

//Start subscribing to the chat queue
function onConnect() {
  var id = client.subscribe("/exchange/web/chat", function(d) {
    var node = document.createTextNode(d.body + '\n');
    document.getElementById('chat').appendChild(node);
  });
}

//Send a message to the chat queue
function sendMsg() {
  var msg = document.getElementById('msg').value;
  client.send('/exchange/web/chat', { "content-type": "text/plain" }, msg);
}

function onError(e) {
  console.log("STOMP ERROR", e);
}

function onDebug(m) {
  console.log("STOMP DEBUG", m);
}