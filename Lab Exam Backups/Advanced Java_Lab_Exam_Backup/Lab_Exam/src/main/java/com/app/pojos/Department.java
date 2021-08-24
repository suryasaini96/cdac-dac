package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dept_tbl")
public class Department extends BaseEntity {
	
	@Column(name = "dept_name",length = 20,unique = true)
	private String name;

	@Column(length = 20)
	private String location;
		
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "dept")
	List<Employee> employees = new ArrayList<>();
	
	public Integer getStrength() {
		return this.employees.size();
	}
	
	public Integer getId() {
		return super.getId();
	}
	
	public void addEmployee(Employee employee)
	{
		employees.add(employee);
		employee.setDepartment(this);		
	}
	public void removeEmployee(Employee employee)
	{
		employees.remove(employee);
		employee.setDepartment(null);		
	}
}
