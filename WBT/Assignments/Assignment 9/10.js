var fs = require('fs');
var empid = "1002";
var resignDate = "03-06-2021";

fs.readFile('emp.txt', (err,data) => {
    if (err) throw err;
    var details = data.toString().split("\n");
    // Using for loop and not forEach because it won't break and waste iterations
    for (i=0; i<details.length; i++){
        var line = details[i].split(":");
        var id = line[0];
        if (empid == id){
            var name = line[1];
            var resignationDetails = "\n" + line[0] + ":" + name + ":" + resignDate;
            fs.appendFile('resignedEmp.txt', resignationDetails, (e)=>{
                if(e) console.log("Error appending to resignation details file.");
                console.log("Resignation details added.");
            });
            break;
        }   
    }
})