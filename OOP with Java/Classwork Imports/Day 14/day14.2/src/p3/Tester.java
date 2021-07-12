package p3;

public class Tester {

	public static void main(String[] args) {
		Formula ref=new MyFormula();//up casting
		System.out.println(ref.calculate(123));
		System.out.println(ref.sqrt(15, 12));
		//ref.show();
		Formula.show();//i/f method
		MyFormula.show();//cls method
		
		
	
	}

}
