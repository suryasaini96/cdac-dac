package p4;

public class FilePrinter implements Printable {
	@Override
	public void print(String mesg) {
		System.out.println("printing a mesg in a file "+mesg);
	}
	//can imple class add additional func ? YES
	public void convert(String mesg)
	{
		System.out.println("printing uppercased mesg in a file "+mesg.toUpperCase());
	}
}
