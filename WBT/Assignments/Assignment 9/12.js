const fs = require('fs');

fs.readFile('sample.txt', (err,data)=>{
    if(err) throw err;
    var arrayOfLines = data.toString().split("\n");
    arrayOfLines.forEach((line,i) =>{
        var newLine = i+1 + " " + line;
        console.log(newLine);
    })
})