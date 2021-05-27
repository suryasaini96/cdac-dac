import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) {
		
		int a[] = new int[] {3,4,4,5,5};
		int b[] = new int[] {4,4,5,5};
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i:a) 
			if (!map.containsKey(i)) map.put(i, 1);
		
		for (int i:b)
			if(map.containsKey(i)) map.put(i, map.get(i)+1); 
		
		System.out.println("Array a: " + Arrays.toString(a));
		System.out.println("Array b: " + Arrays.toString(b));
		System.out.print("Common elements: ");
		for (Map.Entry<Integer, Integer> k: map.entrySet()) 
			if (k.getValue()>1) System.out.print(k.getKey() + " ");
		
	}
}