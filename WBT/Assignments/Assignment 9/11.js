var book = {
    bookid : 1,
    name : "Mathematics for Class 12th",
    author : "R.S Aggarwal",
    price : 500
};

var fs = require('fs');
fs.appendFile('book.txt', JSON.stringify(book,null,2), (err) =>{
    if (err) throw err;
    else console.log("Data written successfully.");
})


