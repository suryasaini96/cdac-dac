import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter char: ");
		char c = sc.next().charAt(0);
		System.out.println("ASCII: " + (int)c);
		
		sc.close();
		
	}

}
