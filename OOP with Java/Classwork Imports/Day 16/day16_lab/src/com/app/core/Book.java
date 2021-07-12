package com.app.core;
//Book details : title(string),category(enum),price(double),publishDate,authorName(string),quantity(int)

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private Category category;
	private double price;
	private transient LocalDate publishDate;
	private String author;
	private int quantity;
	public Book(String title, Category category, double price, LocalDate publishDate, String author, int quantity) {
		super();
		this.title = title;
		this.category = category;
		this.price = price;
		this.publishDate = publishDate;
		this.author = author;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", category=" + category + ", price=" + price + ", publishDate=" +publishDate
				+ ", author=" + author + ", quantity=" + quantity + "]";
	}
	public String getTitle() {
		return title;
	}
	public Category getCategory() {
		return category;
	}
	public double getPrice() {
		return price;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public String getAuthor() {
		return author;
	}
	public int getQuantity() {
		return quantity;
	}
	
	

}
