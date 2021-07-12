package iterators;

import static utils.CollectionUtils.populateSampleData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import com.app.core.BankAccount;

public class Test7 {

	public static void main(String[] args) {
		ArrayList<BankAccount> list = populateSampleData();
		for(BankAccount a : list)
			System.out.println(a);
//display elems in the reverse order
		 //attach listItr , to place the cursor after last elem
		System.out.println("Printing elems in reverse order");
		ListIterator<BankAccount> litr=list.listIterator(list.size());
		while(litr.hasPrevious()) {
			System.out.println(litr.previous());
			System.out.println(litr.previousIndex()+" "+litr.nextIndex());
		}

		System.out.println("main over...");

	}

}
