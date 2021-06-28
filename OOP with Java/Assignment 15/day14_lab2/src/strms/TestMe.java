package strms;

import java.util.Optional;
import java.util.stream.Stream;

public class TestMe {
	public static void main(String[] args) {
		Stream<String> stringStream = Stream.of("A", "B", "C", "D");
	//	Stream<String> stringStream = Stream.of();
		Optional<String> result1 = stringStream.findFirst();
		System.out.println(result1.get());
//		Optional<String> result2 = Stream.of("A", "B", "C", "D").findAny();
//		System.out.println(result2.get());
		stringStream.findAny();		//illegal state exc : strm alrdy closed!
	}

}
