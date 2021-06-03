var names = ["John","Jack","Jerry","Julius"];
var str = names.join(" | ");

var fs = require('fs');

fs.writeFile('names.txt', str, err=> {
    if (err) throw err;
    console.log('Written to file.');
})