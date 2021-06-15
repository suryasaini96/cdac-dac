package test_static;

public class Tester {
	static {
		System.out.println("in tester's static init block");
	}

	public static void main(String[] args) {
		System.out.println("in main");
		//access A's data : first A.class gets loaded in method area
		System.out.println(A.data);
		//invoke show()
		A.show();

	}

}
