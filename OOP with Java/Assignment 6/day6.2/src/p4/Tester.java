package p4;

public class Tester {

	public static void main(String[] args) {
		Printable[] printables = { new ConsolePrinter(), new FilePrinter() };// 3 objects : 1 : array of i/f type of
																				// refs,
		// ConsolePrinter n FilePrinter
		//invoke print() on all printables + invoke convert()
		for(Printable p : printables) {
			p.print("same mesg");//run time poly(DMD)
			if (p instanceof FilePrinter)
			((FilePrinter)p).convert("mesg to convert");//ClassCastException : CP cant' be cast into FP
			else 
				System.out.println("can't convert!!!!!");
		}

	}

}
