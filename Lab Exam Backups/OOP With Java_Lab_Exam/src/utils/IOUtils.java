package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import com.app.core.Book;

import exception.BookHandlingException;

public interface IOUtils {
	static void writeToFile(List<Book> cart) throws BookHandlingException {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cart.ser"))){
			oos.writeObject(cart);
			System.out.println("\nCart contents saved to cart.ser");
		}catch(IOException e) {
			throw new BookHandlingException("\nCannot write to file!");
		}
	}
}
