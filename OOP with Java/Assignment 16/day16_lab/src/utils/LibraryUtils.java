package utils;

import java.util.HashMap;
import java.util.Map;

import com.app.core.Book;

import static com.app.core.Category.*;
import static java.time.LocalDate.parse;

public interface LibraryUtils {
//add a  method to store book details in a map
	static Map<String, Book> populateBookMap() {
		HashMap<String, Book> map = new HashMap<>();
		map.put("book1", new Book("book1", SCIENCE, 500, parse("2015-01-01"), "Rama", 10));
		map.put("book2", new Book("book2", FICTION, 400, parse("2016-11-01"), "Riya", 15));

		map.put("book3", new Book("book3", FICTION, 550, parse("2017-05-21"), "Riya", 4));

		map.put("book4", new Book("book4", SCIENCE, 600, parse("2018-12-21"), "Rama", 5));

		map.put("book5", new Book("book5", FINANCE, 750, parse("2019-07-08"), "Raj", 7));
		return map;
	}
}
