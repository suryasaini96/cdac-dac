package p1;

public class MyFormula implements Formula{

	@Override
	public double calculate(double a) {
		System.out.println("imple abstract method in myformula");
		return a*a;
	}
	

}
