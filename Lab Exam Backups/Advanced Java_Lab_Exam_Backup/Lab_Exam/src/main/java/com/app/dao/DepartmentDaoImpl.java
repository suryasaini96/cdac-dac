package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;

@Repository
public class DepartmentDaoImpl implements IDepartmentDao {
	
	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Department> getDepartments() {
		String jpql = "select d from Department d";
		return manager.createQuery(jpql, Department.class).getResultList();
	}
	
	@Override
	public Department getDepartmentDetails(Integer dept_id) {
		String jpql = "select d from Department d where d.dept_id = :department_Id";
		return manager.createQuery(jpql, Department.class).setParameter("department_Id", dept_id).getSingleResult();
	}
}
