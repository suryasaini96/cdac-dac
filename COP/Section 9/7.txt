public class Main {
	
	public static void main(String[] args) {
		int n = 3;
		System.out.println("Factorial: " + fact(n));
	}
	
	static int fact(int n) {
		if(n==1)
			return 1;
		return n*fact(n-1);
	}
}