package nested_class;

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
		//how to access k ?
		Outer outer=new Outer(123);
		Outer.Inner in=outer.new Inner(34);//stronger form of asso. : composition
		
	}
	//non static method
	public void test()
	{
		System.out.println("in outer's test "+i+" "+j);
		//which inner's members it can access directly ? : static data members (InnerClassName.memberName)
		Inner in=new Inner(12);
		System.out.println("k="+in.k+" "+Inner.l);
	}
	//non static nested class : private/default/protected/public
	 class Inner{
		private int k;
		private static final int l=2345;
//		static  {
//			l=12345;
//		}
		//constr 
		public Inner(int k) {
			super();
			this.k = k;
		}
		//static method : NO
//		public static display()
//		{
//			
//		}
		//non static method : YESS
		public void innerDisplay()
		{
			System.out.println("from inner's non static method "+" "+i+" "+j+" "+k+" "+l);
		}
		
	}
	
	

}
