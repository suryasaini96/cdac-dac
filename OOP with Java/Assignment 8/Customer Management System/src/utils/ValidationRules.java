package utils;

import static main.Customer.sdf;

import java.text.ParseException;
import java.util.Date;

import exception.CustomerHandlingException;
import main.Customer;
import main.CustomerType;

public final class ValidationRules {
	
	// Wrapper method
	public static final Customer getCustomer(String name, String email, String password, double amt, String date, String type, Customer[] customers) throws CustomerHandlingException {
		Date d = getDob(date);
		CustomerType t = getCustomerType(type);
		if (checkEmail(email) && checkPassword(password) && checkRegAmount(amt) && d!=null && t!=null) {
			for(Customer c: customers) {
				if (c!=null) 
					if(c.getEmail().equals(email))
						throw new CustomerHandlingException("Customer already exists!");
			}
		}
		return new Customer(name, email, password, amt, d, t);
	}
	
	// Helper functions 
	private static boolean checkEmail(String email) throws CustomerHandlingException {
		String regex = "\\w+@\\w+\\.com";
		if (!email.matches(regex)) throw new CustomerHandlingException("Email is wrong!");
		return true;
	}
	
	private static boolean checkPassword(String password) throws CustomerHandlingException {
		if (!(password.length()>=4 && password.length()<=10)) throw new CustomerHandlingException("Password is wrong!");
		return true;
	}
	
	private static boolean checkRegAmount(double amt) throws CustomerHandlingException {
		if(!(amt%500==0.0)) throw new CustomerHandlingException("Amount is wrong!");
		return true;
	}
	
	private static Date getDob(String date) throws CustomerHandlingException {
		Date dob = null;
		Date when = null;
		try{
			dob = sdf.parse(date);
			when = sdf.parse("1-1-1995");
			if (!dob.before(when)) throw new ParseException("", 0);
		} catch (ParseException e) {
			throw new CustomerHandlingException("Date is wrong!");
		}
		return dob;
	}
	
	private static CustomerType getCustomerType(String type) throws CustomerHandlingException {
		CustomerType t = null;
		try {
			t = CustomerType.valueOf(type.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new CustomerHandlingException("CustomerType is wrong!");
		}
		return t;
	}
}
