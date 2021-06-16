package method_overloading;

public class Test1 {
	private double add(int i, double j) {
		return i + j;
	}
	double add( double j,int i) {
		return i + j+10;
	}
	public static void main(String[] args) {
		Test1 t1=new Test1();
		//t1.add(10,20);
	//	t1.add(10.0f, 13.67);
		byte b1=100;
		short s1=23456;
	//	t1.add(b1, s1);
	}
	
}

