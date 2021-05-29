import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		int avg;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter marks in P C M : ");
		String[] m = sc.nextLine().split(" ");
		int t=0;
		for (String s:m) t+=Integer.parseInt(s);
		avg = t/3;
		String div = (avg>=80.0)?"Distinction":((avg>=60.0 && avg<80.0)?"First":((avg>=30.0 && avg<60.0)?"Second":"Fail"));
		
		System.out.println("Division: " + div);
		
		sc.close();
	}
}