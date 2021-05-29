public class Main {
	
	public static void main(String[] args) {
		int a = 5;
		int b = 2;
		System.out.println(power(a,b));
	}
	
	static int power(int a, int b) {
		if (b==0)
			return 1;
		return a*power(a,--b);
	}
}