package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IEmployeeDao;
import com.app.pojos.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	public String addEmployee(Employee emp, Integer dept_id) {
		return employeeDao.addEmployee(emp, dept_id);
	}

}
