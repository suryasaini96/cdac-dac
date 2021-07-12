package p3;

public class MyFormula implements Formula{

	@Override
	public double calculate(double a) {
		System.out.println("imple abstract method in myformula");
		return a*a;
	}
	//can you override static methods ? NO : can be re declared!
	//@Override
	static void show()
	{
		System.out.println("imple class static method");
		//how to refer to i/f static method
		Formula.show();
	}
	

}
