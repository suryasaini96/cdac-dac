import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter width: ");
		double w = sc.nextDouble();
		System.out.println("Enter height: "); 
		double h = sc.nextDouble();
		
		System.out.println("Area: " + w*h + " Perimeter: " + 2*(w+h));
		sc.close();
	}

}
