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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Emp other = (Emp) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

//	@Override
//	public boolean equals(Object o) {
//		System.out.println("in emp eq");
//		if (o instanceof Emp) {
//			Emp e = (Emp) o;
//			return id == e.id && name.equals(e.name);
//		}
//		return false;
//	}
//
//	@Override
//	public int hashCode() {
//		System.out.println("in hashCode");
//		return id + name.hashCode();// what's being followed ? Mandatory n Optional
////	return 100;//what's being followed ? Mandatory
//	}
	

}
