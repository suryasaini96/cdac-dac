import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Year: ");
		int y = sc.nextInt();
		boolean leap = false;
		
		if (y%4==0) {
		      if (y%100==0) {
		        if (y%400==0) leap = true;
		        else leap = false;
		      }
		      else leap = true;
		}    
		
		if(leap) System.out.println("Leap year.");
		else System.out.println("Not a leap year.");
		
		sc.close();	
	}
}