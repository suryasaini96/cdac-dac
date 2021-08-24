package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Department;
import com.app.service.IDepartmentService;

@Controller
@RequestMapping("/dept")
public class DeptController {
	
	@Autowired
	private IDepartmentService deptService;
	
	public DeptController() {
		System.out.println("In def constr : "+getClass().getName());
	}
	
	@GetMapping("/display")
	public String displayDepartments(Model map) {
		List<Department> departments = deptService.getDepartments();
		System.out.println(departments);
		map.addAttribute("departments", departments);
		return "/dept/departments";
	}
}
