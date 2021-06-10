import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueNumbers {

	public static void main(String[] args) {
		int arr[] = new int[] {1, 2, 3, 2, 3, 3, 4};
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i:arr) 
			set.add(i);
		
		int j=0;
		int res[] = new int[set.size()];
		for (int i:set)
			res[j++] = i;
		
		System.out.println(Arrays.toString(res));
		
		/* I could have used 2 loops but the time complexity would have
		 * been O(n^2). The optimal solution is to use a HashSet to 
		 * add the elements (set has unique values).
		 * Solution in: O(n)
		 */
	}
}
