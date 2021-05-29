import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number:");
		int n = Math.abs(sc.nextInt());
		int temp = n;
		int sum=0;
		while (temp!=0) {
			int r=temp%10;
			sum+=fact(r);
			temp=temp/10;
		}
		
		if (n==sum) System.out.println("Strong number.");
		else System.out.println("Not strong number.");
	
		sc.close();
	}
	
	static int fact(int n) {
		if (n==0) return 1;
		return n*fact(n-1);
	}
		
}