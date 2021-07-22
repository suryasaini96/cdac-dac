package tester;

import dependency.SoapTransport;
import dependent.ATMImpl;

public class TestATM {

	public static void main(String[] args) {
		ATMImpl atm=new ATMImpl();//dependent obj
		atm.setMyTransport(new SoapTransport());//creating the dependency n wiring(D.I)
		atm.withdraw(1000);//B.L

	}

}
