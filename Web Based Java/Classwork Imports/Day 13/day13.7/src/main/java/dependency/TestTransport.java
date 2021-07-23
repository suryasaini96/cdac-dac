package dependency;

import org.springframework.stereotype.Component;

@Component
//If no name is provided, it will derive as testTransport automatically
//Default scope: singleton, Eager
public class TestTransport implements Transport {
	public TestTransport() {
		System.out.println("in cnstr of " +getClass().getName());
	}

	@Override
	public void informBank(byte[] data) {
		System.out.println("informing bank using " + getClass().getName() + " layer");

	}

}
