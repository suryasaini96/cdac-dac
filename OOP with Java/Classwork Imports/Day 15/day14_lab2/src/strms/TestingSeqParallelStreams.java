package strms;

import java.util.Arrays;
import java.util.List;

public class TestingSeqParallelStreams {

	public static void main(String[] args) {
		List<Integer> ints=Arrays.asList(12,34,56,1,2,50,-67);
		System.out.println("Seq processing of streams");
		//display elems using forEach
		ints.stream()//Stream of Integer : ref type : seq stream 
		.forEach(i->System.out.print(i+" "));
		System.out.println("\nParallel processing of streams");
		ints.parallelStream() //Stream of Integer : ref type : parallel stream 
		.forEach(i->System.out.print(i+" "));

	}

}
