package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

import com.app.core.Product;

/*
 * 3.5 IOUtils : i/f
add a method to write sorted product data to the text file (using buffers) 
 */
public interface IOUtils {
	static void storeProductDetails(Stream<Product> productStream, String fileName) throws IOException {
		// Java App ---> PW ---> FW ---> text file
		try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
			productStream.forEach(pw::println);
		}
	}
}
