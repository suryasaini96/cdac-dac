import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		int a,b;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter two numbers: ");
		String[] nums = sc.nextLine().split(" ");
		a = Integer.parseInt(nums[0]);
		b = Integer.parseInt(nums[1]);
		
		if (a==b) System.out.println("First and second number are equal.");
		else System.out.println("First and second number are not equal.");
		
		sc.close();
	}

}
