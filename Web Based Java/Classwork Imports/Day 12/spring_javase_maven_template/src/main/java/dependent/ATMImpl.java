package dependent;


import dependency.HttpTransport;
import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;//dependency
	public ATMImpl() {
		System.out.println("in cnstr of " +getClass().getName()+" "+myTransport);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing "+amt);
		byte[] data=("depositing "+amt).getBytes();
		myTransport.informBank(data);//dependent obj is invoking the method of it's dependency

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing "+amt);
		byte[] data=("withdrawing "+amt).getBytes();
		myTransport.informBank(data);//dependent obj is invoking the method of it's dependency
	}
	//setter based Dependency Injection(D.I)
	public void setMyTransport(Transport myTransport) {
		System.out.println("in set transport "+myTransport);
		this.myTransport = myTransport;
	}
	
	
}
