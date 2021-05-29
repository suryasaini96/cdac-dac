import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter basic pay: ");
		float b = sc.nextFloat();		
		double inHand = b + 0.40*b - 0.12*b + 1200 + 800 - 300;
		System.out.println("In hand salary: " + inHand);
		sc.close();
	}

}
