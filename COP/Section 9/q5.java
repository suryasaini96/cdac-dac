---------- Solution 1 --------------
O(n)

public class Main {
	
	public static void main(String[] args) {
		int n = 5;
		if (n==1) System.out.print("0");
		else if (n==2) System.out.print("0 1 ");
		else fib(0,1,n-2);
	}
	
	static void fib(int a, int b, int n) {
		if (n==0)
			return;
		System.out.print(a+b + " ");
		fib(b,a+b, --n);
		
	}
}

---------- Solution 2 --------------
O(2^n)

public class Main {
	
	public static void main(String[] args) {
		int n = 5;
		for (int i = 0; i < n; i++)
			System.out.print(fib(i) + " ");
	}
	
	static int fib(int n) {
		if (n<=1)
			return n;
		return fib(n-1) + fib(n-2);
	}
}