import java.util.Scanner;

public class Sphere {
	
	private double r;
	
	public Sphere(double r) {
		this.r = r;
	}
	
	public double surfaceArea() {
		return 4*Math.PI*this.r*this.r;
	}
	
	public double volume() {
		return (4*Math.PI*this.r*this.r*this.r)/3;
	}
	
	public void display() {
		System.out.println("Surface Area: " + surfaceArea() + " metered square");
		System.out.println("Volume of sphere: " + volume() + " metered cube");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter radius in meters: ");
		double r = sc.nextDouble();
		Sphere mySphere = new Sphere(r);
		
		mySphere.display();
		sc.close();	
		
		/* Using multiple class serves no point. I have used the constructor
		 * and two functions for calculation and one for display.
		 * Could you please frame the question more correctly next time. Thanks. 
		 */
			
	}

}
