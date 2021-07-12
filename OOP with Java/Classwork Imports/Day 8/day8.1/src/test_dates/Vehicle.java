package test_dates;

import java.text.SimpleDateFormat;
import java.util.Date;

// registrationNo : String , color : String , price : double
public class Vehicle {
	private String regNo;
	private String color;
	private double price;
	private Date manufactureDate;
	//SDF : 1 copy 
	public static SimpleDateFormat sdf;
	
	static  {
		 sdf=new SimpleDateFormat("dd-MM-yyyy");
	}
	

	public Vehicle(String regNo, String color, double price, Date manufactureDate) {
		super();
		this.regNo = regNo;
		this.color = color;
		this.price = price;
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String toString() {
		return "Vehicle [regNo=" + regNo + ", color=" + color + ", price=" 
	+ price + "produced on " + sdf.format(manufactureDate);//formatted date string
	}

	@Override
	public boolean equals(Object anotherVehicle) {
		System.out.println("in vehicle's eq");
		if (anotherVehicle instanceof Vehicle)
			return regNo.equals(((Vehicle) anotherVehicle).regNo);// ClasscastExc : string --->X --> Vehicle
		return false;
	}

}
