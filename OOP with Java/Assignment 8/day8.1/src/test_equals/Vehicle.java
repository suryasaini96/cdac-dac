package test_equals;

// registrationNo : String , color : String , price : double
public class Vehicle {
	private String regNo;
	private String color;
	private double price;

	public Vehicle(String regNo, String color, double price) {
		super();
		this.regNo = regNo;
		this.color = color;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Vehicle [regNo=" + regNo + ", color=" + color + ", price=" + price + "]";
	}
	public boolean equals(Vehicle anotherVehicle)
	{
		System.out.println("in vehicle's eq");
		return regNo.equals(anotherVehicle.regNo);
	}

}
