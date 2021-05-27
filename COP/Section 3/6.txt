import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		int a;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter age: ");
		a = sc.nextInt();
		
		if (a>=18) System.out.println("Eligible to vote.");
		else if (a>=0 && a<18) System.out.println("Ineligible to vote.");
		else System.out.println("Wrong age.");
		
		sc.close();
	}

}
