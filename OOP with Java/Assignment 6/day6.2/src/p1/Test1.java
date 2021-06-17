package p1;

public class Test1 {

	public static void main(String[] args) {
	//	Printable p=new Printable(); : RHS : err
		//direct referencing
		ConsolePrinter cp=new ConsolePrinter();
		cp.print("some mesg!!!");
		FilePrinter fp=new FilePrinter();
		fp.print("another mesg!!!!");
	

	}

}
