package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.app.core.Book;

public interface IOUtils {
	//store book details in a bin file using serialization
	static void storeData(Map<String, Book> books,String fileName) throws IOException
	{
		//Java App --->OOS(ser) --->FOS( Bin File)
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fileName)))
		{
			out.writeObject(books);//ser : JVM chks serializability of the entire obj graph(HM --String ---Book X
		}
	}
	//restore book details from a bin file using de-serial
	@SuppressWarnings("unchecked")
	static Map<String, Book> restoreData(String fileName) //throws ClassNotFoundException
	{
		 //Java App <---- OIS <----FIS(bin file)
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName)))
		{
			//de serial
			return (Map<String, Book>)in.readObject();
		}catch (Exception e) { //trying to catch : I/O related errs n other excs
			//de serial : failed => ret empty map
			return new HashMap<>();
		}
	}

}
