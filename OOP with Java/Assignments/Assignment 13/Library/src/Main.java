import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
					System.out.println("6. Exit");
					System.out.println("Enter choice: ");
					switch(sc.nextInt()) {
					case 1: System.out.println("Enter book details: ");
							System.out.println("Book(String title, String category, double price, String publishDate, String authorName)");
							Book b = new Book(sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next());
							if (map.containsKey(b))
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
					default:
					case 6: exit = true;
							System.out.println("Exited");
					}
				} catch (ParseException e) {
					e.getStackTrace();
				}
			}
		}
	}
}
