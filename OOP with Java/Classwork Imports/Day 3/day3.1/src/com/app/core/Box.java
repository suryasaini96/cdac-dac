package com.app.core;

public class Box {
    // state : non static data members : instance vars : mem allocated on heap
    private double width, depth, height;

    // add a parameterized constr to init complete state of a box
    public Box(double w, double d, double height) {
        width = w;
        depth = d;
        // to un hide instance var from method local var
        this.height = height;
    }

    // add overloaded constr (same name , different signature)to init a cube
    public Box(double side) {
        // width = depth = height = side;
        // usage : this(....) : constructor chaining
        this(side, side, side);
    }

    public Box() {
        this(-1);
    }

    // To return Box details in String form (dimensions of Box)
    public String getBoxDetails() {
        // this keyword is added implicitly while referring to instance vars
        return "Box dims " + width + " " + depth + " " + height;
    }

    // 2. To return computed volume of the box.
    public double getBoxVolume() {
        return width * depth * height;
    }

    // add a method to check equality of 2 boxes
    // usage : b1.checkEqual(b2)
    // invoker (this) ---> b1 --> 1st box obj
    // anotherBox ---> b2 --> 2nd box obj
    public boolean checkEqual(Box anotherBox)// anotherBox=b2;
    {
        return this.width == anotherBox.width && depth == anotherBox.depth && height == anotherBox.height;
    }// after method rets : how many candidates for GC : 0
    
    
    public double getWidth() {
    	return this.width;
    }
    
    public void setWidth(double width) {
    	this.width = width;
    }
    
}