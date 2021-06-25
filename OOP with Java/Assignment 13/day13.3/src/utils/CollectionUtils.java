package utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import com.app.core.BankAccount;

import custom_exception.AccountHandlingException;
import static com.app.core.AccountType.*;
import static utils.ValidationUtils.*;

public class CollectionUtils {
//add a static method for verfying bank account
//	public static BankAccount verifyAccount(int acctNo, ArrayList<BankAccount> accts, String errMesg)
//			throws AccountHandlingException {
//		int index = accts.indexOf(new BankAccount(acctNo));
//		if (index == -1)
//			throw new AccountHandlingException(errMesg);
//		// AL method : public E get(int index)
//		return accts.get(index);
//	}

	// add a static method to return hard coded sample data
	public static ArrayList<BankAccount> populateSampleData() {
		ArrayList<BankAccount> list = new ArrayList<>();
		try {

			list.add(new BankAccount(101, "Rama", SAVING, convertDate("2-3-2020"), 5600, "hdfc-001"));
			list.add(new BankAccount(10, "Ravi", CURRENT, convertDate("12-3-2020"), 3400, "hdfc-001"));
			list.add(new BankAccount(45, "Kiran", SAVING, convertDate("2-3-2020"), 5600, "hdfc-001"));
			list.add(new BankAccount(156, "Geeta", FD, convertDate("24-1-2011"), 1235600, "hdfc-001"));
			list.add(new BankAccount(56, "Priya", SAVING, convertDate("2-3-2020"), 4500, "hdfc-001"));

		} catch (ParseException e) {
			System.out.println("err in sample data " + e);
		}
		return list;
	}
	//add a static method to copy sample data from list ---> map
	public static HashMap<Integer,BankAccount> populateMap(ArrayList<BankAccount> accts)
	{
		HashMap<Integer,BankAccount> map=new HashMap<>();
		for(BankAccount a : accts) 
			System.out.println("Added "+map.put(a.getAcctNo(), a));
		return map;
	}
	

}
