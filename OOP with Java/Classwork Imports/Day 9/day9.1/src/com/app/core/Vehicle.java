package com.app.core;

import java.text.SimpleDateFormat;
import java.util.Date;

// registrationNo : String , color : String , price : double
public class Vehicle {
	private String regNo;
	private String color;
	private double price;
	private Date manufactureDate;
	// Vehicle HAS-A Category (many to one)
	// Category ---> Vehicle (one ---> many)
	private Category vehicleCategory;
	//composition : stronger form of asso : HAS-A 
	//Vehicle HAS-A DeliveryAddress
	private DeliveryAddress address;

	// SDF : 1 copy
	public static SimpleDateFormat sdf;

	static {
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}

	public Vehicle(String regNo, String color, double price, Date manufactureDate, Category vehicleCategory) {
		super();
		this.regNo = regNo;
		this.color = color;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.vehicleCategory = vehicleCategory;
	}
	

	public Vehicle(String regNo) {
		super();
		this.regNo = regNo;
	}


	@Override
	public String toString() {
		return "Vehicle [regNo=" + regNo + ", color=" + color + ", price=" + price + " produced on "
				+ sdf.format(manufactureDate) + vehicleCategory+" delivery address "+address;// formatted date string
		
		// toString of Category enum
	}

	@Override
	public boolean equals(Object anotherVehicle) {
		System.out.println("in vehicle's eq");
		if (anotherVehicle instanceof Vehicle)
			return regNo.equals(((Vehicle) anotherVehicle).regNo);
//			return regNo.equals(((Vehicle) anotherVehicle).regNo)
//					&& manufactureDate.equals(((Vehicle) anotherVehicle).manufactureDate);
		return false;
	}
	//add a method in the outer class , to associate/link delevery address to the vehicle
	public void linkDeliveryAddress(String city, String state, String zipCode, String phoneNo)
	{
		address=new DeliveryAddress(city, state, zipCode, phoneNo);
	}
	
	//non static nested class : inner class
	public class DeliveryAddress
	{
		private String city,state,zipCode,phoneNo;

		public DeliveryAddress(String city, String state, String zipCode, String phoneNo) {
			super();
			this.city = city;
			this.state = state;
			this.zipCode = zipCode;
			this.phoneNo = phoneNo;
		}

		@Override
		public String toString() {
			return "DeliveryAddress [city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", phoneNo="
					+ phoneNo + "]";
		}
		
	}

}
