package var_args;

public class Test1 {

	public static void main(String[] args) {
		testMe();
		String[] strArray= {"one","two","three"};
		testMe(strArray);
		testMe("four","five");

	}
	private static void testMe(String... strings)
	{
		System.out.println("Strings ");
		for(String s : strings)
			System.out.println(s.toUpperCase());
	}

}
