package generics;

import java.util.Arrays;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		Integer[] data= {10,12,2,3,45,100,null,-10,10,12,10,null};//auto boxing
		//create fixed size list containing refs of Integer
		//Arrays class API : generic method eg.
		//public static <T> asList(T... args)
		List<Integer> intList=Arrays.asList(data);//FIXED SIZE list
		System.out.println(intList);
		intList.set(0, intList.get(0)*2);
		System.out.println(intList);
		System.out.println(intList.getClass().getName());
		intList.add(1234);//UnsupportedOpExc
		

	}

}
