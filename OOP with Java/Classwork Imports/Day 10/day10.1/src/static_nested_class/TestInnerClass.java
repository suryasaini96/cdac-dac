package static_nested_class;

public class TestInnerClass {

	public static void main(String[] args) {
		// invoke innerDisplay() ,to display all 4 data members
		Outer.Inner in=new Outer.Inner(45);
		in.innerDisplay();
		

	}

}
