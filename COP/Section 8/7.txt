import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		int a[] = new int[] {3,4,4,5};
		int k = 6;
		List<Integer> indices = new ArrayList<Integer>();
		
		for(int i=0; i<a.length; i++) 
			if (a[i]==k) indices.add(i);
		
		if(indices.size()!=0) System.out.println("Element " + k +" found at indices: " + indices);
		else System.out.println("Element " + k + " not found!");
	}
}