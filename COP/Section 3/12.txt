import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Temperature: ");
		int t = sc.nextInt();
		
		if (t<=0) System.out.println("Freezing weather");
		else if (t>0 && t<=10) System.out.println("Very Cold weather");
		else if (t>10 && t<=20) System.out.println("Cold weather");
		else if (t>20 && t<=30) System.out.println("Normal in Temp");
		else if (t>30 && t<40) System.out.println("Its Hot");
		else System.out.println("Its Very Hot");
		
		sc.close();
			
	}

}
