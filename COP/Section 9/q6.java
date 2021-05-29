public class Main {
	
	public static void main(String[] args) {
		int n = 532;
		System.out.println("Sum of digits: " + sumDigits(n));
	}
	
	static int sumDigits(int n) {
		if(n==0)
			return 0;
		return n%10 + sumDigits(n/10);
	}
}