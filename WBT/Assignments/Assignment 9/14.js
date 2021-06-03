var http = require('http');
var greetObj = require('./greet');

var server = http.createServer(function(req,resp){
    var greeting = greetObj.greet();
    var content_length = greeting.length;
    resp.writeHead(200, {
        'Content-Length': content_length,
        'Content-Type': 'text/plain'
    });
    resp.end(greeting);
});

server.listen(3000, "localhost");
console.log("Server running at http://localhost:3000/");