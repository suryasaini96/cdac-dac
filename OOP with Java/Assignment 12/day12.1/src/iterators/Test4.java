package iterators;

import static utils.CollectionUtils.populateSampleData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.app.core.BankAccount;

public class Test4 {

	public static void main(String[] args) {
		ArrayList<BankAccount> list = populateSampleData();

		// Display elems using explicit iterator
		// attach the itr :
		Iterator<BankAccount> acctItr = list.iterator();
	//	acctItr.remove();//IllegalStateException
		// acctItr : placed before the 1st elem
		while (acctItr.hasNext()) {
			System.out.println(acctItr.next());// acctItr : after the last elem
			acctItr.remove();
	//		acctItr.remove();//IllegalStateException
			
		}
		System.out.println(list);//[]
		System.out.println("main over...");

	}

}
