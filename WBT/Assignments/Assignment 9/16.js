var rect = require("./rectangle");
var http = require('http');

http.createServer(function(req,resp){
    var myURL = new URL(req.url, "http://localhost:3000/");
    var params = myURL.searchParams;
    var length = params.get('length');
    var breadth = params.get('breadth');
    var area = rect.calcArea(length,breadth);
    var perimeter = rect.calcPerimeter(length,breadth);
    var body = "<body>Area: " + area + "<br>Perimeter: " + perimeter + "</body>";
    resp.writeHead(200,{
        'Content-Type' : 'text/html',
        'Content-Length': body.length
    });
    resp.end(body);
}).listen(3000, "localhost");

console.log("Server up and running.");