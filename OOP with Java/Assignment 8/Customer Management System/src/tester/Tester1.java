package tester;

import java.util.Scanner;

import exception.CustomerHandlingException;
import main.Customer;
import static utils.ValidationRules.getCustomer;

public class Tester1 {

	public static void main(String[] args) {
		Customer[] customers = new Customer[2];
		int ch,i=0;
		try (Scanner sc = new Scanner(System.in)){
			do {
				System.out.println("1. Register customer");
				System.out.println("2. View all customer details");
				System.out.println("3. Exit");
				System.out.println("Enter choice: ");
				ch = sc.nextInt();
				switch (ch) {
				case 1: System.out.println("Enter Customer(String name, String email, String password, double registrationAmount, String dob,"
						+ "String CustomerType) ");
						Customer cust = getCustomer(sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),customers);
						if(i!=customers.length) 
							customers[i++] = cust;
						else throw new CustomerHandlingException("Can't have more customers!");
						break;
				case 2: for(Customer c: customers) 
							if(c!=null)
								System.out.println(c.toString());
						break;
				case 3: System.out.println("Exited!");
						break;
				default: ch=3;
						break;
				}
			}while(ch!=3);
		} catch (CustomerHandlingException e) {
			System.out.println(e.getMessage());
		}
	}

}
