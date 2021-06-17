package p4;

public class ConsolePrinter implements Printable{

	@Override
	public void print(String mesg) {
		System.out.println("printing a mesg on the console "+mesg);
		//can imple class access i/f constants ? : YES , HOW : DIRECTLY 
		System.out.println("i/f constant "+DATA);
		
	}

}
