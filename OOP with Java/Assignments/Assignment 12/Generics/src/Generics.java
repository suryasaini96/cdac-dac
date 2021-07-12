import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Generics {
	
	// 3.3
	public static <T extends Number> double sum(Collection<T> c) {
		double sum = 0;
		for (T t: c) 
			sum += t.doubleValue();
		return sum;
	}
	
	// 3.4
	public static <T extends Number> boolean addToList(List<T> list, T x){
		return list.add(x);
	}
	
	public static void main(String[] args) {
		// 3.1
		List<String> src = Arrays.asList("A","B","C");
		Collections.shuffle(src);
		
		//3.2
		List<Object> dest = Arrays.asList("D","E","F");
		Collections.copy(dest, src);
		System.out.println(dest);
		
		//3.4
		List<Number> numbers = new ArrayList<Number>();
		numbers.add(1);
		numbers.add(2.0);
		numbers.add(3.0f);
		addToList(numbers, 0);
		System.out.println(numbers);
	}

}
