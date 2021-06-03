var http = require('http');
var fs = require('fs');

fs.readFile('welcome.html', (err,html) =>{
    if (err) throw err;
    var server = http.createServer(function(req,resp){
        resp.writeHead(200, {
            "Content-Type": "text/html"
        });
        resp.write(html);
        resp.end();
    }).listen(3000, "localhost");
    console.log("Server running at http://localhost:3000/");
})

