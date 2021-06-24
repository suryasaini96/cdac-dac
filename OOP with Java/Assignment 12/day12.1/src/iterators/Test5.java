package iterators;

import static utils.CollectionUtils.populateSampleData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.app.core.BankAccount;

public class Test5 {

	public static void main(String[] args) {
		ArrayList<BankAccount> list = populateSampleData();

		// Display elems using explicit iterator
		// attach the itr :
		Iterator<BankAccount> acctItr = list.iterator();
		list.remove(list.size() - 1);// removing last elem : no exc :
	//	acctItr = list.iterator();
		while (acctItr.hasNext()) {
			System.out.println(acctItr.next());// acctItr : after the last elem : throws ConcModExc.
		}

		System.out.println("main over...");

	}

}
