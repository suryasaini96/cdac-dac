package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;

	private ATMImpl(Transport t123) {
		myTransport = t123;
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);// dependent obj is calling method of the dependency

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);// dependent obj is calling method of the dependency
	}

	// init style method
	public void myInit() {
		System.out.println("in init " + myTransport);
	}

	// destroy style method
	public void myDestroy() {
		System.out.println("in destroy " + myTransport);
	}
	//Factory method based D.I
	public static ATMImpl myFactory(Transport t)
	{
		System.out.println("in factory method");//invoked by SC
		return new ATMImpl(t);//dependent obj creation n linking --Prog
	}

}
