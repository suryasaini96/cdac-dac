package strms;

import java.util.stream.IntStream;

public class TestLazyEvalStreams {

	public static void main(String[] args) {
		System.out.println("What will be o/p");
		IntStream.rangeClosed(5, 10)// int stream 5 10
				.filter(i -> {
					System.out.println("Filtering " + i);
					return i % 2 == 0;
				})// in stream of all even ints bet 5 10
				.map(i -> {
					System.out.println("Mapping " + i);
					return i + 1;
				});
		

	}

}
