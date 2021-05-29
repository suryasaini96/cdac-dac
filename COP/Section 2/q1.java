import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name: ");
		String name = sc.next();
		
		System.out.println("Hello " + name + " , Welcome to Java World.");
		sc.close();
		
	}

}