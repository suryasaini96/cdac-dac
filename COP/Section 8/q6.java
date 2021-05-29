public class Main {
	
	public static void main(String[] args) {
		
		int a[] = new int[] {3,4,4,5};
		int k = 6;
		boolean contains = false;
		
		for (int i:a) {
			if (i==k) {contains = true; break;}
		}
		
		if (contains) System.out.println("Array contains " + k);
		else System.out.println("Array does not contain " + k);
	}
}