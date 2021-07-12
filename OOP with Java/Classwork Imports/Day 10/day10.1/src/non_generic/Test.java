package non_generic;

public class Test {

	public static void main(String[] args) {
		// create a holder class instance that can hold a double value
		Holder h1=new Holder(10.34);//double -----> Double ---> Object
		double val=(Double)h1.getRef();//Prog : down casting (object--->Double) javac : auto un boxing
		// create a holder class instance that can hold a string data
		Holder h2=new Holder("some string");//up casting (string ---->object)
		String s=(String)h2.getRef();//explicit down casting
		h1=h2;
		val=(Double)h1.getRef();//class cast exc : String can't be cast to Double
		System.out.println(val);
		

	}

}
