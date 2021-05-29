import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		
		int a[] = new int[] {3,4,4,5};
		int b[] = new int[] {1,2};
		int c[] = new int[a.length+b.length];		
		int k = 0;
		for(int i=0; i<a.length; i++) {
			if(i==a.length-1) {
				c[k++] = a[i];
				for (int j=0; j<b.length; j++) 
					c[k++] = b[j];	
			}
			else c[k++] = a[i]; 
		}
		
		System.out.println("Concatenated array: " + Arrays.toString(c));
		
	}
}