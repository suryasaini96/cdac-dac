package char_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class BufferedFileCopyFP {

	public static void main(String[] args) {
		System.out.println("Enter src n dest file names for copying");
		try (Scanner sc = new Scanner(System.in);
				// Java app <----BR <---- FR (src text file)
				BufferedReader br = new BufferedReader(new FileReader(sc.nextLine()));
				// Java app ---> PW ---> FW (dest txt file)
				PrintWriter pw = new PrintWriter(new FileWriter(sc.nextLine()))) {
			// read data from buffer of BR : FP ---BR API : public Stream<String> lines()
			br.lines()// Stream<String>
					.forEach(pw::println);// forEach(line -> pw.println(line))
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
