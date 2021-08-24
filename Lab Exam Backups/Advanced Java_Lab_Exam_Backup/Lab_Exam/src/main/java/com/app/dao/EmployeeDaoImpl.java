package com.app.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;
import com.app.pojos.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
		
	@Autowired
	EntityManager manager;

	@Override
	public String addEmployee(Employee emp, Integer dept_id) {
		Department dept = manager.find(Department.class, dept_id);
		dept.addEmployee(emp);
		return "Employee added successfully";
	}
}
