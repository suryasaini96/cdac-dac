public class Main {
	
	public static void main(String[] args) {
		int a = 5;
		int b = 4;
		System.out.println(product(a,b));
	}
	
	static int product(int a, int b) {
		if (b==0)
			return 0;
		return a + product(a,--b);
	}
}