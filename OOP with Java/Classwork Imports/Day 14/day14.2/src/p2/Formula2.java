package p2;

public interface Formula2 {
	
	double calculate(double a);// public n abstract
	// public

	default double sqrt(double a, double b) {
		System.out.println("i/f def method another imple");
		return Math.sqrt(a * b);
	}
}