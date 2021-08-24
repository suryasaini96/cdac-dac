package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {
	
	@Column(length = 20)
	private String name;

	@Column(length = 20, unique = true)
	private String email;

	@Column(length = 20)
	private Double salary;
	
	@Column(name="dob")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	@Column(name="join_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate join_date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id")
	private Department dept;
	
	public Employee() {
		System.out.println("In def constr : " + getClass().getName());
	}

	public Employee(String name, String email, Double salary, LocalDate dob) {
		super();
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getJoin_date() {
		return join_date;
	}

	public void setJoin_date(LocalDate join_date) {
		this.join_date = join_date;
	}
	
	public Department getDepartment() {
		return dept;
	}

	public void setDepartment(Department department) {
		this.dept = department;
	}
	
}
