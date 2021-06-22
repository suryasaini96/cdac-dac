package generic;

import java.util.Arrays;

public class Test2 {

	public static void main(String[] args) {
		Holder<int[]> h1=new Holder<>(new int[] {1,2,3,4,5,6});
		int[] arr=h1.getRef();
		System.out.println(Arrays.toString(arr));
		Holder<Integer[]> h2=new Holder<>(new Integer[] {1,2,3,4,5,6});//int ---> Integer
		Integer[] arr2=h2.getRef();
	}

}
