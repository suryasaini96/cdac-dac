package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

import com.app.core.Product;

public interface IOUtils {
//add a static method for restoring HM in java heap from bin strm
	@SuppressWarnings("unchecked")
	static Map<Integer, Product> restoreProductDetails(String fileName)throws IOException,ClassNotFoundException
	{
		//Java App <-----OIS <----FIS (bin file)
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName)))
		{
			return (Map<Integer, Product>)in.readObject();//map
		}
	}
}
