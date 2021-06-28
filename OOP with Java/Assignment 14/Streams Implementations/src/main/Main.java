package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.app.core.Category;
import com.app.core.Product;
import static utils.CollectionUtils.*;

public class Main {

	public static void main(String[] args) {
		
		// 1. IntStream of primitive array 
		int[] array = {1,2,3,4,5};
		System.out.println("Using lambda expression");
		Arrays.stream(array).forEach(e -> System.out.print(e + " "));
		System.out.println("\nUsing method reference");
		Arrays.stream(array).forEach(System.out::print);
		
		// 2. Stream of primitive array 
		List<Integer> list = new ArrayList<>(Arrays.asList(22,31,16,9,4));
		System.out.println("\nUsing sequential stream on ArrayList");
		list.stream().forEach(e -> System.out.print(e + " "));
		System.out.println("\nUsing parallel stream on ArrayList");
		list.parallelStream().forEach(e -> System.out.print(e + " "));
		
		// 3. IntStream of range of even integers
		System.out.println("\nStream of even numbers from 1 to 100");
		IntStream.range(1, 101).filter(i -> i%2==0).forEach(i -> System.out.print(i + " "));
		
		// 4. Filter products based on condition
		List<Product> products = populateData();
		System.out.println("\nEnter category and price: ");
		String category1 = "oil";
		double price = 500;
		products.stream().filter(p -> {
			if (p.getProductCatgeory().equals(Category.valueOf(category1.toUpperCase()))) {
				if (p.getPrice()>price)
					return true;
			}
			return false;	
		}).forEach(p -> System.out.println(p));
		
		// 5. Sum of all even nos. between 1-100
		System.out.println(IntStream.range(1, 101).filter(i -> i%2==0).sum());
		
		// 6. Sum of product prices of a specific category
		String category2 = "oil";
		double sum = products.stream()
		.filter(p -> p.getProductCatgeory().equals(Category.valueOf(category2.toUpperCase())))
		.mapToDouble(p -> p.getPrice()).sum();
		System.out.println("Sum of product prices of " + category2 + " category is: " + sum);
		
		// 7. Average of product prices of a specific category
		String category3 = "grains";
		double avg = products.stream()
				.filter(p -> p.getProductCatgeory().equals(Category.valueOf(category3.toUpperCase())))
				.mapToDouble(p -> p.getPrice()).average().orElse(-1);
		System.out.println("Average of product prices of " + category3 + " category is: " + avg);
		
		// 8. Most expensive product
		System.out.print("Most expensive product is: ");
		Product mostExpensive = products.stream().max((p1,p2) -> Double.compare(p1.getPrice(), p2.getPrice())).orElse(null);
		System.out.println(mostExpensive);

	}
}
