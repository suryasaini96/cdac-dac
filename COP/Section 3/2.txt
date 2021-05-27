public class Main {
	
	public static void main(String[] args) {

		int a = 10;
		int b = 20;
		
		a = a + b;
		b = a - b; // b = a
		a = a - b; // a = b
		
		System.out.println("a:" + a + " b:" + b);
		
		
	}

}
