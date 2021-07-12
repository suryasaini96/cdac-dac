package p4;

import static utils.CollectionUtils.populateSampleData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.app.core.BankAccount;

public class Test6 {

	public static void main(String[] args) {
		// get populated list of accts
		ArrayList<BankAccount> list = populateSampleData();
		// display orig list
		list.forEach(a -> System.out.println(a));
		String s="hello";// string literal
		int count=1235;//int literal
		
		//function literal : func i.f ref ---> lambda expr
		Comparator<BankAccount> acctComparator=(a1, a2) -> {
			// date
			int ret = a1.getCreationDate().compareTo(a2.getCreationDate());
			if (ret == 0)
				return ((Double) a1.getBalance()).compareTo(a2.getBalance());
			return ret;
		};
		// sort as per date n balance
		Collections.sort(list,acctComparator);
		System.out.println("sorted list");
		list.forEach(a -> System.out.println(a));
		

	}

}
