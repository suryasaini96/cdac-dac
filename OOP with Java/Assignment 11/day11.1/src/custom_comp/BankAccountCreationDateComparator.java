package custom_comp;

import java.util.Comparator;

import com.app.core.BankAccount;

public class BankAccountCreationDateComparator implements Comparator<BankAccount> {
	@Override
	public int compare(BankAccount a1, BankAccount a2) {
		System.out.println("in compare : date");
//		if(a1.getCreationDate().before(a2.getCreationDate()))
//			return -1;
//		if(a1.getCreationDate().after(a2.getCreationDate()))
//			return 1;
//		return 0;
		return a1.getCreationDate().compareTo(a2.getCreationDate());
		
	}
}
