public class Circle {

	private double r;

	public Circle(double r) {
		super();
		this.r = r;
	}
	
	public double calcuateArea() {
		return Math.PI*this.r*this.r;
	}
	
	public double calculatePerimeter() {
		return 2*Math.PI*this.r;
	}
	
}

----------------------------------------

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		double r;
		Scanner sc = new Scanner(System.in);
		System.out.println("Radius of circle: ");
		r = sc.nextDouble();
		Circle circle = new Circle(r);
		System.out.println("Area: " + circle.calcuateArea());
		System.out.println("Perimeter: " + circle.calculatePerimeter());
		
		sc.close();

	}

}

