package dependent;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dependency.Transport;

//Bean ID: my_atm, singleton and eager
//Dependency: test layer
@Component("my_atm")
public class ATMImpl implements ATM {
	//Autowire by default is byType
	@Autowired
	@Qualifier("testTransport")//Changed to byName now
	private Transport myTransport;//field level D.I.
	public ATMImpl() {
		System.out.println("in cnstr of " +getClass().getName()+" "+myTransport);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing "+amt);
		byte[] data=("depositing "+amt).getBytes();
		myTransport.informBank(data);/*Dependent object is calling method of the dependency */

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing "+amt);
		byte[] data=("withdrawing "+amt).getBytes();
		myTransport.informBank(data);/*Dependent object is calling method of the dependency */
	}
	
	/*init style method*/
	@PostConstruct
	public void myInit()
	{
		System.out.println("In init() " + myTransport);
	}
	
	/*destroy style method*/
	@PreDestroy
	public void myDestroy()
	{
		System.out.println("In destroy() " + myTransport);
	}
}
