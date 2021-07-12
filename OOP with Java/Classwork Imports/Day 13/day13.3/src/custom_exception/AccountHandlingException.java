package custom_exception;

public class AccountHandlingException extends Exception {
	public AccountHandlingException(String mesg) {
		super(mesg);
	}
}
