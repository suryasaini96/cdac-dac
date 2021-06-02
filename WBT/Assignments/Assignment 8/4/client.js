var circle = require("./circle");
var rectangle = require("./rectangle");
var triangle = require("./triangle");

var r = 1;
console.log("Circle:");
console.log(circle.calcArea(r));
console.log(circle.calcCircumference(r));
console.log(circle.calcDiameter(r));

var l=2,b=3;
console.log("Rectangle:");
console.log(rectangle.calcArea(l,b));
console.log(rectangle.calcPerimeter(l,b));

var s1=3,s2=3,s3=3;
console.log("Triangle:");
console.log(triangle.isEquilateral(s1,s2,s3));
console.log(triangle.calcPerimeter(s1,s2,s3));



