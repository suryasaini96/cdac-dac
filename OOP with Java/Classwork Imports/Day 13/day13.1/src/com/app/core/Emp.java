package com.app.core;

public class Emp {
	private int id;
	private String name;
	private double salary;

	public Emp(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public boolean equals(Object o) {
		System.out.println("in emp eq");
		if (o instanceof Emp)
			return id == ((Emp) o).id;
		return false;
	}

	@Override
	public int hashCode() {
		System.out.println("in hashCode");
		return id;// what's being followed ? Mandatory n Optional
//	return 100;//what's being followed ? Mandatory
	}

}
