package static_nested_class;

public class Outer {
	private int i;
	private static int j;
	static {
		j=100;
	}
	public Outer(int i) {
		super();
		this.i = i;
	}
	//static method
	public static void show()
	{
		System.out.println("in outer's show "+j);
		Inner in=new Inner(1234);
		System.out.println(in.k+" "+Inner.l);
		
	}
	//non static method
	public void test()
	{
		System.out.println("in outer's test "+i+" "+j);
		Inner in=new Inner(123);
		System.out.println(in.k+" "+Inner.l);
	
	}
	// static nested class : private/default/protected/public
	static class Inner{
		private int k;
		private static  int l;
		static  {
			l=12345;
		}
		//constr 
		public Inner(int k) {
			super();
			this.k = k;
		}
		//static method : YES
		public static void display()
		{
			System.out.println("from inner's  static method "+" "+" "+j+" "+" "+l);
		}
		//non static method : YESS
		public void innerDisplay()
		{
			System.out.println("from inner's non static method "+" "+" "+j+" "+k+" "+l);
		}
		
	}
	
	

}
