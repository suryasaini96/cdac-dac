import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number:");
		int n = sc.nextInt();
		
		System.out.println("Factorial: " + fact(n));
	
		sc.close();
	}
	
	static int fact(int n) {
		if (n==0) return 1;
		return n*fact(n-1);
	}
		
}