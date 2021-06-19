package main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
	private String name;
	private String email;
	private String password;
	private double registrationAmount;
	private Date dob;
	private CustomerType type;
	
	public static SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}
	
	public Customer(String name, String email, String password, double registrationAmount, Date dob,
			CustomerType type) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", password=" + password + ", registrationAmount="
				+ registrationAmount + ", dob=" + dob + ", type=" + type + "]";
	}

	public String getEmail() {
		return email;
	}
	
	
}
