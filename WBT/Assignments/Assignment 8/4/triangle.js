function isEquilateral(side1,side2,side3){
    return (side1==side2 && side1==side3);
}

function calcPerimeter(side1,side2,side3){
    return side1+side2+side3;
}

module.exports = {isEquilateral,calcPerimeter};