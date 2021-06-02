function calcArea(length,breadth){
    return length*breadth;
}

function calcPerimeter(length,breadth){
    return 2*(length+breadth);
}

module.exports = {calcArea,calcPerimeter};