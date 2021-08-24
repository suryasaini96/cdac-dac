package com.app.dao;

import java.util.List;

import com.app.pojos.Department;

public interface IDepartmentDao {
	List<Department> getDepartments();
	Department getDepartmentDetails(Integer dept_id);
}
