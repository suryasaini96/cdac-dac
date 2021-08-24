package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IDepartmentDao;
import com.app.pojos.Department;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	IDepartmentDao deptDao;

	@Override
	public List<Department> getDepartments() {
		return deptDao.getDepartments();
	}

}
