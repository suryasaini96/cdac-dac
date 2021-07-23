package dependency;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//Bean id: http, singleton, lazy
@Component("http")
@Lazy(value = true)
public class HttpTransport implements Transport {
	public HttpTransport() {
		System.out.println("in cnstr of " +getClass().getName());
	}

	@Override
	public void informBank(byte[] data) {
		System.out.println("informing bank using " + getClass().getName() + " layer");

	}

}
