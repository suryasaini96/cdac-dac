import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
	String title;
	Category category;
	double price;
	Date publishDate;
	String authorName;
	
	public static SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("dd-MM-yyyy"); 
	}
	
	public Book(String title, String category, double price, String publishDate, String authorName) throws ParseException {
		super();
		this.title = title;
		this.category = Category.valueOf(category.toUpperCase());
		this.price = price;
		this.publishDate = sdf.parse(publishDate);
		this.authorName = authorName;
	}
	
	public Book(String title) {
		super();
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", category=" + category + ", price=" + price + ", publishDate=" + publishDate
				+ ", authorName=" + authorName + "]";
	}
}
