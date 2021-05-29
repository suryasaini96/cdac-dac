import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		int a;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number: ");
		a = sc.nextInt();
		
		if (a>0) System.out.println("1");
		else if (a<0) System.out.println("-1");
		else System.out.println("0");
		
		sc.close();
	}

}
