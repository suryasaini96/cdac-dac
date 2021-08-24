package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.core.Book;
import com.app.core.Category;

public interface CollectionUtils {
	static List<Book> populateBooks(){
		List<Book> books = new ArrayList<>();
		books.add(new Book("MATHEMATICS", "R.D Sharma",400,Category.valueOf("EDUCATIONAL"), LocalDate.parse("2012-11-12")));
		books.add(new Book("DETECTIVE STORIES", "Sherlock Holmes",200,Category.valueOf("NOVEL"), LocalDate.parse("2013-09-25")));
		books.add(new Book("DS & ALGORITHMS", "Thomas Cormen",800,Category.valueOf("EDUCATIONAL"), LocalDate.parse("2016-02-23")));
		books.add(new Book("GENERAL SCIENCE", "Ravi Bhushan",100,Category.valueOf("EDUCATIONAL"), LocalDate.parse("2009-01-03")));
		books.add(new Book("POWER OF SUBCONCIOUS MIND", "Joseph Murphy",150,Category.valueOf("NOVEL"), LocalDate.parse("2011-08-15")));
		return books;
	}
}
