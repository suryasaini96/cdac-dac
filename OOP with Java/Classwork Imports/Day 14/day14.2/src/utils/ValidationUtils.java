package utils;

import static com.app.core.BankAccount.sdf;

import java.text.ParseException;
import java.util.Date;

import com.app.core.AccountType;

import custom_exception.AccountHandlingException;

public class ValidationUtils {
	public static final double MIN_BALANCE;
	static {
		MIN_BALANCE=2000;
	}
	public static double validateBalance(double balance) throws AccountHandlingException
	{
		if(balance < MIN_BALANCE)
			throw new AccountHandlingException("Insufficient Funds!!!!!!");
		return balance;
	}
	public static AccountType convertType(String acctType)
	{
		return AccountType.valueOf(acctType.toUpperCase());
	}
	public static Date convertDate(String date) throws ParseException
	{
		return sdf.parse(date);
	}

}
