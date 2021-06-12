package params_passing;
class TestParamPassing1 {
	public static void main(String[] args) {
		// write a static method to update emp sal.
		Emp e1 = new Emp(1, "aa", 1000);

		System.out.println("orig sal bef  =" + e1.getSal());
		testMe(e1.getSal(), 100);
		System.out.println("in main, after updation  =" 
		+ e1.getSal());
	}

	static void testMe(double sal, double inc) {
		sal += inc;
		System.out.println("in meth sal=" + sal);
	}

}
