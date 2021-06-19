package com.app.core;

import java.text.SimpleDateFormat;
import java.util.Date;

// registrationNo : String , color : String , price : double
public class Vehicle {
	private String regNo;
	private String color;
	private double price;
	private Date manufactureDate;
	//Vehicle HAS-A Category (many to one)
	//Category ---> Vehicle (one ---> many)
	private Category vehicleCategory;
	
	//SDF : 1 copy 
	public static SimpleDateFormat sdf;
	
	static  {
		 sdf=new SimpleDateFormat("dd-MM-yyyy");
	}
	

	public Vehicle(String regNo, String color, double price, Date manufactureDate,Category vehicleCategory) {
		super();
		this.regNo = regNo;
		this.color = color;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.vehicleCategory=vehicleCategory;
	}

	@Override
	public String toString() {
		return "Vehicle [regNo=" + regNo + ", color=" + color + ", price=" 
	+ price + " produced on " + sdf.format(manufactureDate)+vehicleCategory;//formatted date string
		//toString of Category enum
	}

	@Override
	public boolean equals(Object anotherVehicle) {
		System.out.println("in vehicle's eq");
		if (anotherVehicle instanceof Vehicle)
			return regNo.equals(((Vehicle) anotherVehicle).regNo);// ClasscastExc : string --->X --> Vehicle
		return false;
	}

}
