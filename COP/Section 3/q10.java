public class Main {
	
	public static void main(String[] args) {

		int[] a = {-1,-1,-1,-1,-3};
		int s = a[0];
		
		for (int x:a) if(x<s) s=x; 
		System.out.println("Smallest: " + s);
	}

}
