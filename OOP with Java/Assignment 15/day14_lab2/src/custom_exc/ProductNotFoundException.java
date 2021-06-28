package custom_exc;

public class ProductNotFoundException extends Exception {
	public ProductNotFoundException(String mesg) {
		super(mesg);
	}
}
