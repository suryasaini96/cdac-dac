package strms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.app.core.Product;

import static utils.CollectionUtils.populateData;

public class TestMethodReference {

	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(12, 34, 56, 1, 2, 50, -67);
		System.out.println("display via lambda expr : ");
		ints.stream().forEach(i -> System.out.println(i));
		// Is there any way to add more conciseness to lambda expression ? YES : method
		// reference
		// If lambda expression is directly calling existing method in its body : then
		// it can be replaced by a method ref.
		// syntax of meth ref : Invoker object :: existing method name
		System.out.println("display via method ref : ");
		ints.stream().forEach(System.out::println);
		// Can this be replaced by method ref ? NO
		ints.stream().forEach(i -> System.out.print(i + " "));
		// NOW : Sort the products list as per manufacture date : using with method ref.
		// List<Product> --- Stream<Product> : sorted(Comparator)
		// function literal
		Comparator<Product> productComp = (p1, p2) -> p1.getManufactureDate().compareTo(p2.getManufactureDate());
		populateData().stream().sorted(productComp).forEach(System.out::println);
		// OR
		populateData().stream().sorted(Comparator.comparing(p -> p.getManufactureDate())).forEach(System.out::println);
		// OR
		populateData().stream().sorted(Comparator.comparing(Product::getManufactureDate)).forEach(System.out::println);
		// name of the most expensive product
		String name = populateData().stream().max(Comparator.comparing(Product::getPrice)).get().getName();
		System.out.println(name);
		System.out.println("sorting by price");
		List<Product> list = populateData();
		Collections.sort(list, Comparator.comparing(Product::getPrice));
		list.forEach(System.out::println);
		

	}

}
