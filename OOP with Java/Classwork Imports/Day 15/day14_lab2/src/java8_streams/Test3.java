package java8_streams;

import java.util.stream.IntStream;

public class Test3 {

	public static void main(String[] args) {
		//display sum of squares of all odd nos in the 1-50
		int sum=IntStream.range(1, 51)//src : IntStream : ints (1-50)
		.filter(i -> i % 2 != 0)//intermediate op : odd ints : IntStream
		.map(i -> i * i) //intermediate op : sq of  odd ints : IntStream
		.sum();//terminal op
		System.out.println(sum);
		

	}

}
