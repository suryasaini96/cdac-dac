package tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.app.core.Book;

import exception.BookHandlingException;

import static utils.CollectionUtils.*;
import static utils.IOUtils.*;

public class BookShop {
	public static void main(String[] args) throws BookHandlingException {
		List<Book> books = populateBooks();
		List<Book> cart = new ArrayList<>();
		System.out.println("Welcome to the BookShop");
		boolean exit = false;
		try(Scanner sc = new Scanner(System.in)){
			while(!exit) {
				System.out.println();
				System.out.println("1. Display all books from the shop");
				System.out.println("2. Add book to the cart");
				System.out.println("3. Show user cart contents");
				System.out.println("4. Checkout(Exit)");
				System.out.print("Enter choice: ");
				switch(sc.nextInt()) {
				case 1: books.stream().forEach(System.out::println);
						break;
				case 2: System.out.println("Enter book title: ");
						sc.nextLine();
						String title = sc.nextLine().toUpperCase();
						Book purchaseBook = new Book(title);
						List<Book> filteredBooks = books.stream().filter(b->b.equals(purchaseBook)).collect(Collectors.toList()); // Filtering the books based on title to a list
						if (filteredBooks.size()!=0) { // Since list will contain only 1 title or nothing(assuming title as unique for equals method) so used get(0) to get the book details
							cart.add(filteredBooks.get(0));
							System.out.println("Book added to cart.");
						}
						else
							throw new BookHandlingException("Book title not available");
						break;
				case 3: cart.stream().forEach(System.out::println);
						break;
				case 4: System.out.println("---- CART ----");
						cart.stream().forEach(b-> System.out.println(b.getTitle() + " " + b.getPrice())); // Creating a stream to display title and price
						double sum = cart.stream().mapToDouble(Book::getPrice).sum(); // Creating a stream to sum the prices and display
						System.out.println("Total: " + sum);
						writeToFile(cart);
				default:System.out.println("Exited."); 
						exit = true;
						break;
				}
			}
		}	
	}
}
