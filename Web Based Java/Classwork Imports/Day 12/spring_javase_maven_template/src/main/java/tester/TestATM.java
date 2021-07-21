package tester;

import dependency.SoapTransport;
import dependent.ATMImpl;

public class TestATM {

	public static void main(String[] args) {
		//dependent obj
		ATMImpl atm=new ATMImpl();
		//invoke setter
		atm.setMyTransport(new SoapTransport());//soap transport : prog is making dependency available to
		//dependent object
		atm.deposit(5000);//B.L invocation
		System.out.println("main over...");

	}

}
