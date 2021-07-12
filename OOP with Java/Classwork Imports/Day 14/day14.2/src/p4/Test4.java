package p4;

import static utils.CollectionUtils.populateMap;
import static utils.CollectionUtils.populateSampleData;

import java.util.HashMap;

import com.app.core.BankAccount;
import static java.util.Map.Entry;

public class Test4 {

	public static void main(String[] args) {
		// get populated map of accts
		HashMap<Integer, BankAccount> map = populateMap(populateSampleData());
		// display all entries from the map : imperative style
//		for (Entry<Integer, BankAccount> e : map.entrySet())
//			System.out.println(e.getKey() + ":" + e.getValue());
		//OR
		map.forEach((k,v) -> System.out.println(k+" "+v));

	}

}
