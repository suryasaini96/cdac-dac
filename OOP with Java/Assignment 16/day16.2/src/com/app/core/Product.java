package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Product implements Serializable{
	
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L; recommended!
	/**
	 * 
	 */
	private static final long serialVersionUID = -7447493233000512784L;
	private int id;
	private String name;
	private Category productCatgeory;
	private   LocalDate manufactureDate;
	private double price;

	

	public Product(int id, String name, Category productCatgeory, LocalDate manufactureDate, double price) {
		super();
		this.id = id;
		this.name = name;
		this.productCatgeory = productCatgeory;
		this.manufactureDate = manufactureDate;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", productCatgeory=" + productCatgeory + ", manufactureDate="
				+ manufactureDate + ", price=" + price + "]";
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Category getProductCatgeory() {
		return productCatgeory;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
