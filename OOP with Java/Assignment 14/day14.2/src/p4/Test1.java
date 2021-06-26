package p4;

import static p4.Utils.testCompute;

public class Test1 {

	public static void main(String[] args) {
		// add 2 numbers
		System.out.println(testCompute(23, 34, new Computable() {

			@Override
			public double compute(double a, double b) {
				// TODO Auto-generated method stub
				return a + b;
			}
		}));
		// subtraction
		System.out.println(testCompute(23, 34, new Computable() {

			@Override
			public double compute(double a, double b) {
				// TODO Auto-generated method stub
				return a - b;
			}
		}));
		// lambda expression (args) -> {body
//double compute(double a, double b);
//		System.out.println(testCompute(23, 34,(double a,double b)->{return a*b;}));
		System.out.println(testCompute(23, 34, (a, b) -> a * b));

	}

}
