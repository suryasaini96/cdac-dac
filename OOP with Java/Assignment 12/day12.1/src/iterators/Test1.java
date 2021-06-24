package iterators;
import static utils.CollectionUtils.populateSampleData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.app.core.BankAccount;

public class Test1 {

	public static void main(String[] args) {
		ArrayList<BankAccount> list = populateSampleData();
		//display elems in the list
	//	System.out.println(list);//AL's toString
		//for or for-each
		//Display elems using explicit iterator
		//attach the itr :
		Iterator<BankAccount> acctItr=list.iterator();
		System.out.println(acctItr.getClass().getName());//ArrayLIst$Itr : inner class of AL that imple Iterator
		//acctItr : placed before the 1st elem
		while(acctItr.hasNext())
			System.out.println(acctItr.next());
		System.out.println("main over...");
		
		//create a linked list from populated ArrayList
		LinkedList<BankAccount> linkedList=new LinkedList<>(list);
		//LinkedLIst ---IS A Iterable
		Iterator<BankAccount> acctrItr2=linkedList.iterator();
		System.out.println(acctrItr2.getClass().getName());
		while(acctrItr2.hasNext())
			System.out.println(acctrItr2.next());
	
		
		
		

	}

}
