package test_equals2;

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

	@Override
	public boolean equals(Object anotherVehicle) {
		System.out.println("in vehicle's eq");
		if (anotherVehicle instanceof Vehicle)
			return regNo.equals(((Vehicle) anotherVehicle).regNo);// ClasscastExc : string --->X --> Vehicle
		return false;
	}

}
