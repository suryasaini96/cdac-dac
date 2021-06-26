package p2;

public class MyImpleClass implements Formula,Formula2{

	@Override
	public double calculate(double a) {
		System.out.println("in calc");
		return a*a;
	}
	//javac forces the prog to override def inherited method
	@Override
	public  double sqrt(double a, double b) {
		System.out.println("must override dup def method imple");
		//how to refer to super type 's method imple ?
		Formula.super.sqrt(a, b);
		Formula2.super.sqrt(a, b);
		return Math.sqrt(a / b);
	}

}
