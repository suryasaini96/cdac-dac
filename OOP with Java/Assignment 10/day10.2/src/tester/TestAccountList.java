package tester;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.app.core.AccountType;
import com.app.core.BankAccount;
import static utils.ValidationUtils.*;
import static com.app.core.BankAccount.sdf;

public class TestAccountList {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// init of DS
			ArrayList<BankAccount> acctList = new ArrayList<>();// size=0,capa=10
			System.out.println("AL contents ");
			for (BankAccount a : acctList)
				System.out.println(a);
			boolean exit = false;
			while (!exit) {
				System.out.println("Options 1. Create A/C 2. Display All 100. Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Enter A/C details : acctNo, customerName,  type,  creationDate,  balance 	 ifsc) ");
						acctList.add(new BankAccount(sc.nextInt(), sc.next(), convertType(sc.next()),
								sdf.parse(sc.next()), validateBalance(sc.nextDouble()), sc.next()));
						break;

					case 2:
						System.out.println("Bank Accounts");
						for (BankAccount a : acctList)
							System.out.println(a);

						break;
					case 3: // Accept account no & display "Present" or "Absent"
						//Method of AL : public boolean contains(Object o)
						System.out.println("Enter acct no");
						int acctNo=sc.nextInt();
						BankAccount a=new BankAccount(acctNo);
						System.out.println(acctList.contains(a)?"Present":"Absent");
						break;
					case 100:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// read off the pending tokes from the scanner till new line
				sc.nextLine();
			}

		}

	}

}
