package iterators;

import static utils.CollectionUtils.populateSampleData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.app.core.BankAccount;

public class Test6 {

	public static void main(String[] args) {
		ArrayList<BankAccount> list = populateSampleData();

		//implicit itr : for-each
		for(BankAccount a : list)//for 2nd itr : ConcModExc
		{
			System.out.println(a);
			list.remove(a);
		}//MUST be replaced by explicit Iterator

		System.out.println("main over...");

	}

}
