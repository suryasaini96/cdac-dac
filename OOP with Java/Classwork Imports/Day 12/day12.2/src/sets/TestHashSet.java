package sets;

import java.util.Arrays;
import java.util.HashSet;

public class TestHashSet {

	public static void main(String[] args) {
		// Create empty HashSet to store integers
		HashSet<Integer> hs=new HashSet<>();//empty HS
		int[] data= {12,34,1,23,10,12,-10,34};
		System.out.println("orig array "+Arrays.toString(data));
		//populate HS with this data
		for(int i : data) //no impl conversion
			System.out.println("Added "+hs.add(i));//int--> Integer 
		System.out.println("HS "+hs);//no dups , un ordered , un sorted Set
		System.out.println("size "+hs.size());
		System.out.println("HS contains 23 "+hs.contains(23));//true
		System.out.println("remove "+hs.remove(10));//auto boxing
		System.out.println("HS after remove "+hs);
		
		
		

	}

}
