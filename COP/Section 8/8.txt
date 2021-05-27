import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) {
		
		int a[] = new int[] {3,4,4,5,5};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i:a) {
			if (map.containsKey(i)) { map.put(i, map.get(i) + 1); }
			else map.put(i, 1);
		}
		System.out.println("Array: " + Arrays.toString(a));
		System.out.print("Duplicates: ");
		for (Map.Entry<Integer, Integer> k : map.entrySet()) {
			if (k.getValue()>1) System.out.print(k.getKey() + " ");
		}
	}
}