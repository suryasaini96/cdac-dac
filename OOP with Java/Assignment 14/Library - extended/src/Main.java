import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		Map<Book,Integer> map = new HashMap<>();
		boolean exit = false;
		try(Scanner sc = new Scanner(System.in)) {
			while(!exit) {
				try {
					System.out.println("1. Add book");
					System.out.println("2. Display all books in the libary");
					System.out.println("3. Issue out a book");
					System.out.println("4. Return a book");
					System.out.println("5. Remove book");					
					System.out.println("6. Reduce quantity of all old books by 10%");
					System.out.println("7. Display books by category");
					System.out.println("8. Sort books as per title");
					System.out.println("9. Sort books as per author and price");
					System.out.println("10. Exit");
					System.out.println("Enter choice: ");
					switch(sc.nextInt()) {
					case 1: System.out.println("Enter book details: ");
							System.out.println("Book(String title, String category, double price, String publishDate, String authorName)");
							Book b = new Book(sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next());
							if (map.get(b)!=null)
								map.put(b, map.get(b) + 1);
							else
								map.putIfAbsent(b, 1);
							System.out.println("Book added.");
							break;
					case 2: for (Map.Entry<Book, Integer> entry: map.entrySet())
								System.out.println(entry);
							break;
					case 3: System.out.println("Enter title to issue: ");
							Book issueBook = new Book(sc.next());
							if (map.get(issueBook)!=null) {
								int q = map.get(issueBook)-1;
								if (q == 0)
									map.put(issueBook, null);
								else 
									map.put(issueBook, q);
								System.out.println("Book issued.");
							}
							else
								System.out.println("Book not in inventory");
							break;
					case 4: System.out.println("Enter title to return: ");
							Book returnBook = new Book(sc.next());
							if (map.containsKey(returnBook)) {
								if (map.get(returnBook)==null)
									map.putIfAbsent(returnBook, 1);
								else
									map.put(returnBook, map.get(returnBook)+1);
								System.out.println("Book returned.");
							} else
								System.out.println("Book doesn't belong to this library!");
							break;
					case 5: System.out.println("Enter title to remove: ");
							Book removeBook = new Book(sc.next());
							if (map.remove(removeBook) == null)
								System.out.println("Book does not exist!");
							else
								System.out.println("Book removed!");
							break;
					case 6: System.out.println("Enter date before which quantity to reduce by 10%: ");
							Date beforeDate = Book.sdf.parse(sc.next());
							for (Map.Entry<Book, Integer> entry: map.entrySet()) {
								if (entry.getKey().getPublishDate().before(beforeDate)) {
									if (entry.getValue()>0) {
										int q = entry.getValue() - entry.getValue()/10;
										map.put(new Book(entry.getKey().getTitle()), q);
									}	
								}
							}
							System.out.println("Quantity reduced by 10%");
							break;
					case 7: System.out.println("Enter category to display: ");
							try {
								Category category = Category.valueOf(sc.next().toUpperCase());
								for (Map.Entry<Book, Integer> entry: map.entrySet()) {
									if (entry.getKey().getCategory().equals(category) && entry.getValue()>0)
										System.out.println(entry);
								}
							} catch (IllegalArgumentException x) {
								System.out.println("Category does not exist!");
							}
							break;
					case 8: SortedMap<Book,Integer> sortedMap = new TreeMap<>(map);
							for (Map.Entry<Book, Integer> entry: sortedMap.entrySet())
								System.out.println(entry);
							break;
					case 9: List<Book> books = new ArrayList<Book>(map.keySet());
							Collections.sort(books, (b1, b2) -> {
								int comparison = b1.getAuthorName().compareTo(b2.getAuthorName());
								if (comparison == 0)
									return Double.compare(b1.getPrice(), b2.getPrice());
								return comparison;
							});
							for (Book book: books)
								System.out.println(book);
							break;
					default:
					case 10: exit = true;
							System.out.println("Exited");
					}
				} catch (ParseException e) {
					e.getStackTrace();
				}
			}
		}
	}
}
