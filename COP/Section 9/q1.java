public class Main {
	
	public static void main(String[] args) {
		printNatural(10);
	}
	
	static void printNatural(int n) {
		if(n==0)
			return;
		printNatural(--n);
		System.out.print(n+1 + " ");
	}
}