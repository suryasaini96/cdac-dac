package p1;

public class MyFormula2 implements Formula {

	@Override
	public double calculate(double a) {
		System.out.println("imple abstract method in : myformula2");
		return a * a * a;
	}
//can imple class override inherited def func ? : YES

	@Override
	public double sqrt(double a, double b) {
		System.out.println("overridng def func");
		return Math.sqrt(a - b);
	}

}
