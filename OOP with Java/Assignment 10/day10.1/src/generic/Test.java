package generic;

public class Test {

	public static void main(String[] args) {
		// create a holder class instance that can hold a double value
		//Diamond operator <> => generic type of RHS is inferred from LHS 
		Holder<Double> h1=new Holder<>(12.34);//javac : auto boxing (double --->Double) 
		double data=h1.getRef();//javac : auto un boxing 
		
		// create a holder class instance that can hold a string data
		Holder<String> h2=new Holder<>("strings");//javac : No impl conversion
		String s=h2.getRef();
	//	h1=h2;//type mismatch errs are detected by javac
		
		

	}

}
