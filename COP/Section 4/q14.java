public class Main {
	
	public static void main(String args[]) {
		int first = 0;
		int second = 1;
		int n=0;
		
		if (n==1) System.out.println(first);
		else if (n==2) System.out.println(first + " " + second);
		else if (n>2) {
			System.out.print(first + " " + second + " ");
			fib (first,second,n,2);
		}
		else System.out.println("Wrong input!");
		
	}
	
	static void fib (int a, int b, int n, int i) {
		if (n==i) return;
		else {
			int c = a+b;
			a = b;
			b = c;
			System.out.print(c + " ");
			i++;
			fib(a,b,n,i);
		}	
	}

}