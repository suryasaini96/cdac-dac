package p1;

public interface Formula {
	//public static final
	int DATA=1234;
	double calculate(double a);// public n abstract
	// public

	default double sqrt(double a, double b) {
		System.out.println("i/f def method");
		return Math.sqrt(a + b);
	}
}