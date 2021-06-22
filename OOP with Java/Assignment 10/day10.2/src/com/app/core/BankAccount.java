package com.app.core;

import java.text.SimpleDateFormat;
import java.util.Date;

import custom_exception.AccountHandlingException;

import static utils.ValidationUtils.validateBalance;

public class BankAccount {
	private int acctNo;//PK
	private String customerName;
	private AccountType type;
	private Date creationDate;
	private double balance;
	private String ifsc;//Bank 's unique code
	public static SimpleDateFormat sdf;
	static {
		sdf=new SimpleDateFormat("dd-MM-yyyy");
	}
	public BankAccount(int acctNo, String customerName, AccountType type, Date creationDate, double balance,
			String ifsc) {
		super();
		this.acctNo = acctNo;
		this.customerName = customerName;
		this.type = type;
		this.creationDate = creationDate;
		this.balance = balance;
		this.ifsc = ifsc;
	}
	//add overloaded constr wrapping PK
	public BankAccount(int acctNo) {
		super();
		this.acctNo = acctNo;
	}
	@Override
	public String toString() {
		return "BankAccount [acctNo=" + acctNo + ", customerName=" + customerName + ", type=" + type + ", creationDate="
				+ sdf.format(creationDate) + ", balance=" + balance + ", ifsc=" + ifsc + "]";
	}
	
	//B.L methods
	public void deposit(double amount)
	{
		balance += amount;
	}
	public void withdraw(double amount) throws AccountHandlingException
	{
		validateBalance(balance-amount);
		balance -= amount;
	}
	public void transferFunds(BankAccount dest, double amount) throws AccountHandlingException
	{
		//withdraw
		this.withdraw(amount);
		dest.deposit(amount);
	}
	@Override
	public boolean equals(Object o) {
		System.out.println("in acct's equals");
		if(o instanceof BankAccount)
			return acctNo == ((BankAccount)o).acctNo;
		return false;
		
	}
	

}
