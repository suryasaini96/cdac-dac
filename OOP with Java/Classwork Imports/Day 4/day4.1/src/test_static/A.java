package test_static;

public class A {
	static int data;
	//static init block
	static {
		System.out.println("in static init block of class A");
		data=12345;
	}
	public static void show() {
		System.out.println("in static method show....");
	}
}
