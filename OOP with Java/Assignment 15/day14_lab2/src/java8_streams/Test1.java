package java8_streams;

import java.util.ArrayList;
import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		// Create int[] ---> IntStream & display its contents.
		int[] data = { 12, 34, 1, 2, 3, 456, 78 };
		// attach seq stream to int[]
		System.out.println("Attaching seq stream to int[]");
		Arrays.stream(data)// java.util.stream.IntStream : prim types (int)
				.forEach(i -> System.out.print(i + " "));// terminal op
		/*
		 * 2. Create AL<Integer> , populate it. Attach seq stream & display elems
		 * 
		 */
		//can u create populated mutable AL<Integer> in single line ?
		System.out.println();
		System.out.println("Attaching seq stream to AL<Integer>");
		ArrayList<Integer> list=new ArrayList<>(Arrays.asList(12, 34, 1, 2, 3, 456, 78));
		list.stream() //Stream<Integer>
		.forEach(i -> System.out.print(i+" "));
		//Attaching parallel stream to AL<Integer>
		System.out.println();
		System.out.println("Attaching parallel stream to AL<Integer>");
		list.parallelStream().forEach(i -> System.out.print(i+" "));	

	}

}
