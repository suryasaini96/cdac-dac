package strms;

/*
 * 
 Find name of the product which is most expensive.
 */
import static utils.CollectionUtils.populateData;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.app.core.Product;

public class Test3 {

	public static void main(String[] args) {

		List<Product> list = populateData();
		Optional<Product> optionalProduct=list.stream()//Stream<Product>
		.max(Comparator.comparing(Product::getPrice));//Optional<Product> : empty or non empty
		if(optionalProduct.isPresent())
			System.out.println("Name of the most exepnsive product "+optionalProduct.get().getName());
		else
			System.out.println("NO products....");

	}

}
