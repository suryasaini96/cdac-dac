function factorial(){
    var n = arguments[0];
    var fact=1;
    for (i=1; i<=n; i++){
        fact*=i;
    }
    return fact;
}

function myprime(){
    var n = arguments[0];
    if (n==0 || n==1) return false;
    var prime = true;
    for (i=2; i*i<=n; i++){
        if (n%i==0){
            prime = false;
            break;
        }     
    }
    return prime;
}

function printable(){
    var n = arguments[0];
    for (i=1; i<=10; i++){
        console.log(n + " * " + i + " = " + n*i);
    }
}

module.exports = {factorial,myprime,printable};