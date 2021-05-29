import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter num1: ");
		int a = sc.nextInt();
		System.out.println("Enter num2: ");
		int b = sc.nextInt();
		System.out.println("Enter num3: ");
		int c = sc.nextInt();
		System.out.println("Enter num4: ");
		int d = sc.nextInt();
		System.out.println("Enter num5: ");
		int e = sc.nextInt();
		
		System.out.println("Avg: " + (float)(a+b+c+d+e)/5);
		sc.close();
		
	}
}