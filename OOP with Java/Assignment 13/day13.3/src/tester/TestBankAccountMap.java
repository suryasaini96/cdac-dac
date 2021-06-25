package tester;

import static com.app.core.BankAccount.sdf;
import static utils.CollectionUtils.populateMap;
import static utils.CollectionUtils.populateSampleData;
import static utils.ValidationUtils.convertType;
import static utils.ValidationUtils.validateBalance;

import java.util.HashMap;
import java.util.Scanner;

import com.app.core.BankAccount;

import custom_exception.AccountHandlingException;

public class TestBankAccountMap {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// init DS
			HashMap<Integer, BankAccount> acctMap = populateMap(populateSampleData());
			boolean exit = false;
			while (!exit) {
				System.out.println("Options 1. Create A/C 2. Display All 3.Fetch A/C Summary 4.Transfer Funds "
						+ "5 : Close A/C  100. Exit");
				try {
					switch (sc.nextInt()) {
					case 1: // create a/c
						System.out.println(
								"Enter A/C details : acctNo, customerName,  type,  creationDate,  balance 	 ifsc) ");
						System.out.println("Enter acct no");
						int acctNo = sc.nextInt();
						// chk if dup key ???
						if (acctMap.containsKey(acctNo)) // work perfectly!!!!! int ->Integer (Integer's hashCode --->
															// derives BID --> in case of non empty bucket : Integer's
															// equals method
							throw new AccountHandlingException("Dup acct no!!!!!");
						// new key
						System.out
								.println(acctMap.put(acctNo, new BankAccount(acctNo, sc.next(), convertType(sc.next()),
										sdf.parse(sc.next()), validateBalance(sc.nextDouble()), sc.next())));

						break;
					case 2:// display all acct details
						System.out.println(acctMap);// Map's toString {k1:v1,k2:v2....}
						for (BankAccount a : acctMap.values())// Collection<BankAccount>
							System.out.println(a);
						break;
					case 3:// Fetch A/C Summary
						System.out.println("Enter acct no , to fetch the summary");
						BankAccount bankAccount = acctMap.get(sc.nextInt());
						if (bankAccount == null)
							throw new AccountHandlingException("Invalid a/c no !!!!!!");
						System.out.println("A/C summary "+bankAccount);
						break;

					case 4: // transfer funds
						System.out.println("Enter src dest a/c no n transfer amount");
						BankAccount src = acctMap.get(sc.nextInt());
						if (src == null)
							throw new AccountHandlingException("Invalid src a/c no !!!!!!");
						BankAccount dest = acctMap.get(sc.nextInt());
						if (dest == null)
							throw new AccountHandlingException("Invalid dest a/c no !!!!!!");
						// src n dest a/c : valid
						src.transferFunds(dest, sc.nextDouble());

						break;

					case 100:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				sc.nextLine();

			}

		}

	}

}
