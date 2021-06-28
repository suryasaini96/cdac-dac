package utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.app.core.Category.*;
import static java.time.LocalDate.*;

import com.app.core.Product;

public interface CollectionUtils {
	static List<Product> populateData() {
		ArrayList<Product> products = new ArrayList<>();
		// yyyy-MM-dd
		products.add(new Product(100, "mango", FRUITS, parse("2019-12-01"), 500));
		products.add(new Product(10, "rice_bran", OIL, parse("2019-11-21"), 450));
		products.add(new Product(45, "sunflower", OIL, parse("2019-05-11"), 550));
		products.add(new Product(30, "rice", GRAINS, parse("2019-01-13"), 520));
		products.add(new Product(55, "orange", FRUITS, parse("2020-01-01"), 350));
		products.add(new Product(35, "wheat", GRAINS, parse("2018-07-11"), 700));
		return products;
	}

	// add a method : List<Product> ---> Map
	static Map<Integer, Product> populateMap(List<Product> products) {
		Map<Integer, Product> productMap = new HashMap<>();
		products.forEach(p -> productMap.put(p.getId(), p));
		// OR use Collectors.toMap()
		return productMap;
	}

	// add another method for sorting the map as per manufacture date
	static List<Product> sortMap( Map<Integer, Product> map)
	{
		return map.values()//Collection<Product>
		.stream() //Stream<Product>
		.sorted(Comparator.comparing(Product::getManufactureDate))//p -> p.getManufactureDate() : Stream<Product> : sorted 
		.collect(Collectors.toList());
	}
}
