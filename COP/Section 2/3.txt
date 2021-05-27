import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter principal: ");
		float p = sc.nextFloat();
		System.out.println("Enter rate: ");
		float r = sc.nextFloat();
		System.out.println("Enter years: ");
		float t = sc.nextFloat();
		
		System.out.println("SI: " + (p*r*t)/100);
		
		sc.close();
		
	}

}
