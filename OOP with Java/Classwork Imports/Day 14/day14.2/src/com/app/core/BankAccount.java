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
	// Apply interest 
	//i/p period in years & interest rate
	public void applyInterest(int periodInYrs,double rate)
	{
		double simpleInterest=(balance*periodInYrs*rate)/100;
		deposit(simpleInterest);
		
	}
	
	public AccountType getType() {
		return type;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public int getAcctNo() {
		return acctNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public double getBalance() {
		return balance;
	}
	public String getIfsc() {
		return ifsc;
	}
	
	

}
