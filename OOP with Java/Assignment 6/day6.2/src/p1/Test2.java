package p1;
//static import => importing static member/s of the specified type
import static p1.Printable.DATA;
import static java.lang.System.out;
import static java.lang.Math.pow;


public class Test2 {

	public static void main(String[] args) {
		Printable p;//p : interface type of ref.
		//p : interface type of ref. can directly refer to ---> ANY concrete imple class instance (up casting)
		//indirect ref.
		p=new ConsolePrinter();//up casting (implements)
		p.print("a mesg");//javac : in Printable : print , JVM : print : CP (DMD)
		p=new FilePrinter();//IS A 
		p.print("mesg2");
		//can non imple class access i/f constants ? YES 
		out.println("const "+DATA);
		out.println(pow(8,2));
		
		
		
		

	}

}
