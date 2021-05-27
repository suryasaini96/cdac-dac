import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		
		int n[] = new int[] {3,4,4,5};
		int copy[] = new int[n.length];
		
		for(int i=0; i<n.length; i++) 
			copy[i] = n[i];
		
		System.out.println("Array: " + Arrays.toString(n));
		System.out.println("Copyied array: " + Arrays.toString(copy));
		
	}
}