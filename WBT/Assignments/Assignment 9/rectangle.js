function calcArea(length,breadth){
    return length*breadth;
}

function calcPerimeter(length,breadth){
    return 2*(Number(length)+Number(breadth));
}

module.exports = {calcArea,calcPerimeter};