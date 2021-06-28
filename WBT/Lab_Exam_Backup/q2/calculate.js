const fs = require('fs');

fs.readFile('numbers.txt', (err,data)=>{
    if (err) throw err;
    var numbers = data.toString().split("\n");
    var sum = 0;
    var nums = [];
    var avg = 0;
    
    for (i=0; i<numbers.length; i++){
        var sqr = Math.pow(Number(numbers[i]),2);
        nums.push(sqr);
        sum+= sqr;
    }
    avg = sum/numbers.length;

    nums.forEach(num => {
        console.log(num);
    })
    console.log("Total: " + sum);
    console.log("Average: " + avg);

})