package strms;

import java.util.stream.IntStream;

public class TestExecOrder2 {

	public static void main(String[] args) {
		System.out.println("What will be o/p");
		IntStream.rangeClosed(5, 10)// int stream 5 10
				// in stream of all even ints bet 5 10
				.map(i -> {
					System.out.println("Mapping " + i);
					return i + 1;
				}).filter(i -> {
					System.out.println("Filtering " + i);
					return i % 2 == 0;
				}).forEach(i -> {
					System.out.println("Displaying " + i);
				});

	}

}
