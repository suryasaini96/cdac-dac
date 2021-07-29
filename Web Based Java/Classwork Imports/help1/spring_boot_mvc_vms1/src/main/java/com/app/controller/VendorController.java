package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	public VendorController() {
		System.out.println("in ctor of " + getClass().getName());
	}
	//add a req handling method for displaying vendor details
	@GetMapping("/details")
	public String showVendorDetails()
	{
		System.out.println("in show vendor dtls");
		return "/vendor/details";//Actual view name : /WEB-INF/views/vendor/details.jsp
	}
}
