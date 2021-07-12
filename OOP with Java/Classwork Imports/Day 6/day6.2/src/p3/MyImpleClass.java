package p3;

public class MyImpleClass implements A,B{

	@Override
	public double compute(double d1, double d2) {
		System.out.println(A.DATA+" "+B.DATA);
		return 0;
	}
//	@Override
//	public int compute(double d1, double d2) {
//		System.out.println(A.DATA+" "+B.DATA);
//		return 0;
//	}

}
