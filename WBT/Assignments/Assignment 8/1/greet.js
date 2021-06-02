exports.greet = function (){
    var today = new Date();
    var hours = today.getHours();
    if (hours>=5 && hours <=12){
        console.log("Good morning");
    }
    else if (hours>12 && hours <=18){
        console.log("Good afternoon");
    } else {
        console.log("Good evening");
    }
}