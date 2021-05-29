import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter numbers: ");
		String[] str = sc.nextLine().split(" ");
		int sum=0;
		
		for (String s:str) {
			sum+=Integer.parseInt(s);
		}
		System.out.println("Sum: " + sum + " Average: " + sum/10.0);
		sc.close();
	}
}