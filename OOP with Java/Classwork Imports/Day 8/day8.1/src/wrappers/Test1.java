package wrappers;

public class Test1 {

	public static void main(String[] args) {
		Integer i1 = Integer.valueOf(12345);// boxing int --->Integer
		int data = i1.intValue();// un boxing Integer--->int
		i1 = 23456;// auto boxing : javac impl int ---> Integer
		String s = "fdgsfg";
		// s++;//ref : no arithmetic op.
		i1++;// auto un boxing --> inc ---> auto boxing
		Double d1 = 123.456;// auto boxing (double ---> Double)
		double d2 = 123.45F;// widening (float --->double)
		// d1=123.456F;//float ---> Float ---X---> Double
		d1 = (double) 123.456F;// prog : expl casting to double ----> Double (javac)
		Number n1 = 123.456F;// float ---> Float (auto boxing) ---> Number(up casting)
		n1 = 123.45;
		Object ref = false;// boolean --> Boolean -->Object
		ref = 123.456;// auto boxing ---> up casting
		ref = 1234;
		ref = "some string";
		// Is java 100% (pure) object oriented language ? NO
		// Can you refer to ANY data type(prim /ref types) using Object type of ref ?
		// YESS
	}

}
