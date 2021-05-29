import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		
		int arr[] = new int[]{1,2,3,4,5};
		int rev[] = new int[arr.length];
		for(int i=arr.length-1, k=0; i>=0; i--, k++) 
			rev[k] = arr[i];
		
		System.out.println("Array: " + Arrays.toString(arr));
		System.out.println("Reversed Array: " + Arrays.toString(rev));
	}
}
