package p1;

public class FilePrinter implements Printable {
	@Override
	public void print(String mesg) {
		System.out.println("printing a mesg in a file "+mesg);
	}
}
