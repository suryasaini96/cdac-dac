import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter radius: ");
		double r = sc.nextDouble();
		System.out.println("Area: " + Math.PI*r*r + " Perimeter: " + 2*Math.PI*r );
		sc.close();
	}

}
