package com.app.shapes;

public class Circle extends BoundedShape{
	//state : x, y , radius
	private double radius;
	public Circle(int x,int y,double radius) {
		super(x,y);
	}
	//toString
	@Override
	public String toString()
	{
		return "Circle "+super.toString()+" radius="+radius;
	}
	@Override
	public double area()
	{
		return Math.PI*radius*radius;
	}

}
