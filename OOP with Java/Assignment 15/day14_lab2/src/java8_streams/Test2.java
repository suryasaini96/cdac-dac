package java8_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * 3. Create stream of ints between 1-100 & display all even elements. (Hint :
		 * IntStream methods --range,filter,forEach)
		 */
//		IntStream.rangeClosed(1, 100) //IntStream : ints 1---100 : src
//		.filter(i -> i % 2==0)//IntStream : even nos ---intermediate op
//		.forEach(i -> System.out.println(i));//terminal op
		
		IntStream.rangeClosed(1, 100) //IntStream : ints 1---100 : src
	.filter(i -> i % 2==0)//IntStream : even nos ---intermediate op
		.forEach(System.out::println);//terminal op

	}

}
