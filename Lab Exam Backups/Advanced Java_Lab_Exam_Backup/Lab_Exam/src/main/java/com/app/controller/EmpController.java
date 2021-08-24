package com.app.controller;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Employee;
import com.app.service.IEmployeeService;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping("/hire")
	public String showEmployeeForm(@RequestParam int dept_id, Model map) {
		System.out.println(dept_id);
		map.addAttribute("dept_id", dept_id);
		return "/emp/hire";
	}
	
	@PostMapping("/hire")
	public String hireEmployee(@RequestParam String name, @RequestParam String email, @RequestParam Double salary,
			@RequestParam LocalDate dob, @RequestParam Integer dept_id, RedirectAttributes flashAttributes) {
		String message = "Validation failed!";
		int age = calculateAge(dob);
		if (salary>=30000 && salary<=40000 && age>=25 && age<=35) {
			Employee emp = new Employee(name, email, salary, dob);
			message = employeeService.addEmployee(emp, dept_id);
		}
		flashAttributes.addFlashAttribute("message", message);
		if (message.equals("Validation failed!")) {
			return "redirect:/emp/hire";
		}
		return "redirect:/dept/display";
	}
	
	public int calculateAge(LocalDate dob) {
		return Period.between(dob, LocalDate.now()).getYears(); 
	}
}
