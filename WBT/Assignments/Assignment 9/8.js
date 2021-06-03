var fs = require('fs');
var emp = 
[   {
    "empid":1001,
    "empname":"Shyam",
    "salary": 20000
    },
    {"empid":1002,
    "empname":"Ghanshyam",
    "salary": 30000 
    },
    {
    "empid":1003,
    "empname":"Ram",
    "salary": 250000
    }
];

emp.forEach(function(obj){
    var details = [obj.empid,obj.empname,obj.salary].join(":") + "\n";
    fs.appendFile('empDetails.txt', details, err=>{
        if (err) throw err;
        console.log("Written record.");
    })
})

