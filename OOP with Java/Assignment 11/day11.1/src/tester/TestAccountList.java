package tester;

import static com.app.core.AccountType.SAVING;
import static com.app.core.BankAccount.sdf;
import static utils.CollectionUtils.populateSampleData;
import static utils.CollectionUtils.verifyAccount;
import static utils.ValidationUtils.convertDate;
import static utils.ValidationUtils.convertType;
import static utils.ValidationUtils.validateBalance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

import com.app.core.BankAccount;

import custom_comp.BankAccountCreationDateComparator;
import custom_exception.AccountHandlingException;

public class TestAccountList {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// init of DS
			ArrayList<BankAccount> acctList = populateSampleData();
			boolean exit = false;
			while (!exit) {
				System.out.println("Options 1. Create A/C 2. Display All 3.Fetch A/C Summary 4.Transfer Funds "
						+ "5 : Close A/C  6. Apply interest 7.Display Details by date 8. Sort by asc acct no"
						+ "9. Sort by creation date 10. Sort by creation date n balance 100. Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Enter A/C details : acctNo, customerName,  type,  creationDate,  balance 	 ifsc) ");
						acctList.add(new BankAccount(sc.nextInt(), sc.next(), convertType(sc.next()),
								sdf.parse(sc.next()), validateBalance(sc.nextDouble()), sc.next()));// append
						break;

					case 2:
						System.out.println("Bank Accounts");
						for (BankAccount a : acctList) // for-each : implicit iterator() : Iterable<E> i/f
							System.out.println(a);

						break;
//					case 3: // Accept account no & display "Present" or "Absent"
//						//Method of AL : public boolean contains(Object o)
//						System.out.println("Enter acct no");
//						int acctNo=sc.nextInt();
//						BankAccount a=new BankAccount(acctNo);
//						System.out.println(acctList.contains(a)?"Present":"Absent");
//						break;
					case 3: // Accept account no & display a/c summary or throw exc
						System.out.println("Enter acct no");
						System.out.println("A/C Summary "
								+ verifyAccount(sc.nextInt(), acctList, "Fetch Summary Failed : Invalid A/C No !!!!!"));
						break;
					case 4: // Accept src id , dest id & funds transfer.
						System.out.println("Enter src a/c no dest a/c no amount");
						BankAccount src = verifyAccount(sc.nextInt(), acctList, "Invalid src a/c");
						BankAccount dest = verifyAccount(sc.nextInt(), acctList, "Invalid dest a/c");
						// => src n dest a/c : valid
						src.transferFunds(dest, sc.nextDouble());
						// => xfer success
						System.out.println("funds transferred...");
						break;

					case 5:// 1.6 Accept acct id & close a/c --
						System.out.println("Enter a/c no to close a/c");
						// AL API : public boolean remove(Object o)
						boolean removed = acctList.remove(new BankAccount(sc.nextInt()));
						// acctList.remove(verifyAccount(sc.nextInt(), acctList, "A/C Closing failed"));
						if (removed)
							System.out.println("A/c closed.....");
						else
							throw new AccountHandlingException("A/C Closing failed");
						break;
					case 6:
						System.out.println("Enter period n rate");
						int period = sc.nextInt();
						double rate = sc.nextDouble();
						// searching by no PK : can't use :contains/indexOf/lastIndexOf
						for (BankAccount a : acctList)
							if (a.getType().equals(SAVING))
								a.applyInterest(period, rate);
						System.out.println("Applied interest....");
						break;
					case 7:
						// Display names & a/c balance of all bank accounts created after a specific
						// date
						// i/p : threshold date
						Date inputDate = convertDate(sc.next());
						System.out.println(
								"List of customer names n balance for a/c created after " + sdf.format(inputDate));
						for (BankAccount a : acctList)
							if (a.getCreationDate().after(inputDate))
								System.out.println(a.getCustomerName() + " " + a.getBalance());
						break;
					case 8:
						// sort accts as per asc order of acct nos
						Collections.sort(acctList); // no javac error : since acctList : AL IS A List , BankAccount IS-A
													// Comparable
						break;
					case 9:
						// sort accts as per creation date acct nos
						Collections.sort(acctList, new BankAccountCreationDateComparator()); // no javac error : since
																								// acctList : AL IS A
																								// List , BankAccount
																								// IS-A Comparable
						break;
					case 10: // sort by date n balance : anonymous inner class
						Collections.sort(acctList, new Comparator<BankAccount>() {// ano inner cls begin
							@Override
							public int compare(BankAccount a1, BankAccount a2) {
								System.out.println("in compare : date n bal");
								int ret = a1.getCreationDate().compareTo(a2.getCreationDate());
								if (ret == 0) // dates are same
								{
									// balance : double (Double) ---
									// return ((Double) a1.getBalance()).compareTo(a2.getBalance());
									if (a1.getBalance() < a2.getBalance())
										return -1;
									if (a1.getBalance() == a2.getBalance())
										return 0;
									return 1;
								}
								return ret;
							}
						}// ano inner cls end
						);
						break;

					case 100:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// read off the pending tokens from the scanner till new line
				sc.nextLine();
			}

		}

	}

}
