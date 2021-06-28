package char_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class BufferedFileReadFP {

	public static void main(String[] args) {
		System.out.println("Enter file name along with path , to read n display data");
		try (Scanner sc = new Scanner(System.in);
				BufferedReader br = new BufferedReader(new FileReader(sc.nextLine()))) {
			br.lines() // Stream<String> : all lines
					.filter(l -> l.length() < 40) // Stream<String> : lines len < 40
					.forEach(System.out::println);
			System.out.println("file read over....");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over...");

	}

}
