package iterators;
import static utils.CollectionUtils.populateSampleData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.app.core.BankAccount;

public class Test3 {

	public static void main(String[] args) {
		ArrayList<BankAccount> list = populateSampleData();
		System.out.println(list.get(list.size()));//IndexOutOfBoundsExc
		//display elems in the list
	//	System.out.println(list);//AL's toString
		//for or for-each
		//Display elems using explicit iterator
		//attach the itr :
//		Iterator<BankAccount> acctItr=list.iterator();
//		System.out.println(acctItr.getClass().getName());//ArrayLIst$Itr : inner class of AL that imple Iterator
//		//acctItr : placed before the 1st elem
//		while(acctItr.hasNext())
//			System.out.println(acctItr.next());//acctItr : after the last elem
//		System.out.println(acctItr.next());//NoSuchElemExc
//		System.out.println("main over...");
		
		
		

	}

}
