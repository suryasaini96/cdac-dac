public class NumUtil {
	
	static double getPower(int n, double x) {
		return Math.pow(n, x);
	}

	static long getFactorial(int num) {
		if (num==0) return 1;
		return num*getFactorial(num-1);
	}
	
	static boolean isPrime(int num) {
		boolean prime = true;
		for (int i=2; i<=num/2; i++) {
			if (num%i == 0) {
				prime = false;
				break;
			}		
		}
		if(num==0) return false;
		else if (prime) return true;
		else return false;
	}
	
	static boolean isEven(int num) {
		if(num%2==0) return true;
		return false;
	}
	
	static boolean isOdd(int num) {
		if(num%2!=0) return true;
		return false;
	}
}
--------------------------------------
1.1)

public class NumUtilMain {

	public static void main(String[] args) {
		int n = 5;
		double x = 2;
		
		System.out.println("n^x : " + NumUtil.getPower(n,x));
		System.out.println("Factorial : " + NumUtil.getFactorial(n));
		System.out.println("Prime : " + NumUtil.isPrime(n));
		System.out.println("Even : " + NumUtil.isEven(n));
		System.out.println("Odd : " + NumUtil.isOdd(n));
	}
}

--------------------------------------
1.2)

import java.util.Scanner;

public class NumUtilMenuDriven {

	public static void main(String[] args) {
		int c, n;
		double x;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number: ");
		n = sc.nextInt(); sc.nextLine();
		System.out.println("Enter power: ");
		x = sc.nextDouble(); sc.nextLine();
		do {
			System.out.println("\n**** Welcome to Number Utility ****"
					+ "\n1. Calculate power of num"
					+ "\n2. Calculate Factorial"
					+ "\n3. Check Prime"
					+ "\n4. Check Even"
					+ "\n5. Check Odd"
					+ "\n6. Exit"
					+ "\nEnter your choice : ");
			c = sc.nextInt(); sc.nextLine();
			switch (c) {
			case 1: System.out.println(n+"^"+x+" : " + NumUtil.getPower(n,x)); break;
			case 2: System.out.println(n+" Factorial : " + NumUtil.getFactorial(n)); break;
			case 3: System.out.println(n+" is Prime : " + NumUtil.isPrime(n)); break;
			case 4: System.out.println(n+" is Even : " + NumUtil.isEven(n));break;
			case 5: System.out.println(n+" is Odd : " + NumUtil.isOdd(n)); break;
			default: c=6; break;
			}
		}while(c!=6);
		sc.close();
	}
}







