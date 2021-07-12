package sets;

import java.util.Arrays;
import java.util.TreeSet;

public class TestTreeSet {

	public static void main(String[] args) {
		// Create empty HashSet to store integers
		TreeSet<Integer> hs=new TreeSet<>();
		//empty TS : no comparator => Comparable based Natural Ordering
		int[] data= {12,34,1,23,10,12,-10,34};
		System.out.println("orig array "+Arrays.toString(data));
		//populate HS with this data
		for(int i : data) //no impl conversion
			System.out.println("Added "+hs.add(i));//int--> Integer  (Integer's compareTo)
		System.out.println("HS "+hs);//no dups ,un  ordered ,sorted Set
		System.out.println("size "+hs.size());
		System.out.println("HS contains 23 "+hs.contains(23));//true
		System.out.println("remove "+hs.remove(10));//auto boxing
		System.out.println("HS after remove "+hs);
		
		

	}

}
