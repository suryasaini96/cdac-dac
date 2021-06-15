package p1;

public class TestConstrInvocation {

	public static void main(String[] args) {
		//create a sub class object
		C c1=new C();

	}

}

class A //extends Object : impl added by javac
{
	A() {
		//super(); => invocation of immediate super class constr : arg-less constr
		System.out.println("1");
	}
}

class B extends A {
	B() {
		//super();
		System.out.println("2");
	}
}

class C extends B {
	C() {
		//super(); : impl added by javac
		System.out.println("3");
	}
}
