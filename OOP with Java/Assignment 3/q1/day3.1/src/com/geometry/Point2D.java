package com.geometry;

public class Point2D {
    private int x;
    private int y;

    //3.1
    public Point2D(int x, int y){
        this.x = x;
        this.y = y;
    }
    //3.2
    public String getDetails(){
        return "X:" + this.x + " Y:" + this.y;
    }
    //3.3
    public boolean isEqual(Point2D point){
        return this.x == point.x && this.y == point.y;
    }
    //3.4
    public Point2D createNewPoint(int xoff, int yoff){
        return new Point2D(this.x + xoff, this.y + yoff);
    }   
    //3.5
    public double calculateDistance(Point2D point){
        return Math.sqrt(Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2));
    }
    
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
    
    
}
