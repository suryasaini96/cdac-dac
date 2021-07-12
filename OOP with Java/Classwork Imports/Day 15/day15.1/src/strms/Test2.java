package strms;

/*
 * 
7. Display average  of product prices of a specific category.
I/P category name
o/p average 

8. Find name of the product which is most expensive.
 */
import static utils.CollectionUtils.populateData;

import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

import com.app.core.Category;
import com.app.core.Product;

public class Test2 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Product> list = populateData();
			System.out.println("Enter category");
			Category category = Category.valueOf(sc.next().toUpperCase());

			/*
			 * Display avg of product prices of a specific category. I/P category name o/p
			 * sum.
			 */
			// attach strm to list
			OptionalDouble optionalDouble = list.stream() // java.util.stream.Stream<Product> : strm of all products
					.filter(p -> p.getProductCatgeory() == category) // Stream<Product> : filtered strm
					.mapToDouble(Product::getPrice) // DoubleStream : prices of prducts from specified category
					.average();
			if (optionalDouble.isPresent())
				System.out.println(
						"Avg price for products under Category " + category + " : " + optionalDouble.getAsDouble());
			else 
				System.out.println("No products !!!!!");

		}

	}

}
