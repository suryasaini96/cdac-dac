package tester;

import static com.app.core.Category.valueOf;
import static java.time.LocalDate.parse;
import static utils.IOUtils.restoreData;
import static utils.IOUtils.storeData;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Book;
import com.app.core.Category;

import custom_exc.BookHandlingException;

public class BookLibrary {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter file name , to restore data");
			String fileName=sc.next();
			Map<String, Book> books =restoreData(fileName);
			System.out.println("restored map "+books);//{}
					//populateBookMap();
			boolean exit = false;
			while (!exit) {
				System.out.println("Options 1. Add a Book 2.Display All books 5.Remove Book 100.Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter book title");
						String title = sc.next();// use nextLine in case of multiplw words
						if (books.containsKey(title))
							throw new BookHandlingException("Dup Book title!!!!!");
						System.out.println("Enter details : category,  price,  ,  author,  quantity");
						books.put(title, new Book(title, valueOf(sc.next().toUpperCase()), sc.nextDouble(),
								parse(sc.next()), sc.next(), sc.nextInt()));

						break;
					case 2:
						System.out.println("Books in the library");
						books.forEach((k, v) -> System.out.println(v));
						break;
					case 5:
						System.out.println("Enter book title to remove");
						Book removedBook = books.remove(sc.next());
						if (removedBook == null)
							throw new BookHandlingException("Missing book title!!!!");
						System.out.println("Book removed....");
						break;

					case 100:
						exit = true;
						//invoke IOUtils' storeData for string book details
						storeData(books,fileName);
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				sc.nextLine();
			}
		}
	}

}
