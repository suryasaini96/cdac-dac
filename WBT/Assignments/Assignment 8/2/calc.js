function add(a,b){
    return a+b;
}

function sub(a,b){
    return a-b;
}

function mul(a,b){
    return a*b;
}

function div(a,b){
    return (a/b).toFixed(2);
}

function sum(){
    var sum=0;
    for (i=0; i<arguments.length; i++){
        sum+= arguments[i];
    }
    return sum;
}

module.exports = {add,sub,mul,div,sum};