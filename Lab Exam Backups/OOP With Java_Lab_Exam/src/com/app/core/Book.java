package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Book implements Serializable {
	private String title;
	private String author;
	private double price;
	private Category category;
	private LocalDate publishDate;
	
	public Book(String title) {
		super();
		this.title = title;
	}

	public Book(String title, String author, double price, Category category, LocalDate publishDate) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.category = category;
		this.publishDate = publishDate;
	}
	
	// Considering books as equal if title is the same
	// Not an ideal case but used it just to filter out the titles
	// Otherwise this could overridden by if title is same then check author
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

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}

	public Category getCategory() {
		return category;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + ", category=" + category
				+ ", publishDate=" + publishDate + "]";
	}
}
