var fs = require('fs');

fs.readFile('emp.txt', (err,data)=>{
    if(err) return err;

    var details = data.toString().split("\n");
    var sum = 0;
    details.forEach(function(emp,i){
        sum+= parseInt(emp.split(":")[3]);
    })
    console.log("Sum of salary: " + sum);
})