package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Book;

public interface IBookDao {
	//method to fetch all categories
	List<String> fetchAllCategories() throws SQLException;
	//method to fetch books by a chosen category
	List<Book> getBooksByCategory(String category) throws SQLException;
	//method to fetch selected book details from the cart
	List<Book> getCartDetails(List<Integer> cart) throws SQLException;
}
