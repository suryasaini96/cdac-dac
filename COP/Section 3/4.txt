import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		int a;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number: ");
		a = sc.nextInt();
		
		if (a>0) System.out.println("Positive");
		else if (a<0) System.out.println("Negative");
		else System.out.println("Zero");
		
		sc.close();
	}

}
