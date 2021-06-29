package utils;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.stream.Stream;

import com.app.core.Product;

/*
 * 3.5 IOUtils : i/f
add a method to write product map (un sorted) to a bin file using serialization
 */
public interface IOUtils {
	static void storeProductDetails(Map<Integer, Product> map, String fileName) throws IOException {
		//Java App ---> OOS (serializer) ---> FOS (bin File)
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fileName)))
		{
			out.writeObject(map);//ser
		}
	}
}
