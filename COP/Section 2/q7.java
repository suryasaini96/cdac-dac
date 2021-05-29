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
		
		System.out.println("CI: " + p*(Math.pow(1 + r/100, t)));
		
		sc.close();
		
		
	}

}
