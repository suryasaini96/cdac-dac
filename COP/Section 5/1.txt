public class Emp {
	
	private int empId;
	private String name;
	private String dept;
	private double salary;
	private String address;
	
	public Emp(int empId, String name, String dept, double salary, String address) {
		super();
		this.empId = empId;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.address = address;
	}
	
	public void displayEmpDetails() {
		System.out.println("Emp ID: " + this.empId
				+ "\nName: " + this.name
				+ "\nDept: " + this.dept
				+ "\nSalary: " + this.salary
				+ "\nAddress: " + this.address);
	}

}


------------------------------------------------------

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int empId;
		String name;
		String dept;
		double salary;
		String address;
		
		System.out.println("Emp ID: ");
		empId = sc.nextInt(); sc.nextLine();
		System.out.println("Name: ");
		name = sc.nextLine();
		System.out.println("Dept: ");
		dept = sc.nextLine();
		System.out.println("Salary: ");
		salary = sc.nextDouble(); sc.nextLine();
		System.out.println("Address: ");
		address = sc.nextLine();
		
		sc.close();
		
		Emp emp = new Emp(empId, name, dept, salary, address);
		emp.displayEmpDetails();

	}

}

