package strms;

/*
 * 6. Display sum of product prices of a specific category.
I/P category name
o/p sum.


 */
import static utils.CollectionUtils.populateData;

import java.util.List;
import java.util.Scanner;

import com.app.core.Category;
import com.app.core.Product;
public class Test1 {

	public static void main(String[] args) {
		try(Scanner sc= new Scanner(System.in))
		{
			List<Product> list = populateData();
			System.out.println("Enter category");
			Category category=Category.valueOf(sc.next().toUpperCase());
		
		/*
		 * Display sum of product prices of a specific category. I/P category name o/p
		 * sum.
		 */
			//attach strm to list
			double sum=list.stream() //java.util.stream.Stream<Product> : strm of all products
			.filter(p -> p.getProductCatgeory()==category) //Stream<Product> : filtered strm
			.mapToDouble(Product::getPrice) //DoubleStream : prices of prducts from specified category
			.sum();
			System.out.println("Total price for products under Category "+category+" : "+sum);
			
		}

	}

}
