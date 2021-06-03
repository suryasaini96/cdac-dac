var fs = require('fs');

fs.readFile('customer.json', function(err, data){
    if (err) throw err;
    var customerDetails = JSON.parse(data.toString());
    customerDetails.forEach(customer => {
        console.log(customer.name + " " +customer.phone);
    });

    // Or by using for..of loop
    // for (var customer of customerDetails)
    //     console.log(customer.name + " " +customer.phone);
})