package com.app.shapes;

public abstract   class BoundedShape {
	//state : tight encapsulation
	private int x,y;

	public BoundedShape(int x, int y) {
		//super();
		this.x = x;
		this.y = y;
	}
//	@Override
//	public String toString()
//	{
//		return x+" "+y;
//	}

	@Override
	public String toString() {
		return "x=" + x + ", y=" + y;
	}
	public abstract double area();//only method declaration
//	{
//		return -1;
//	}
	
	
}
