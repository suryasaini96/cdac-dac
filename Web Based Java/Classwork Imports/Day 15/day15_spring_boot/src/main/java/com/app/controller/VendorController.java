package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	public VendorController() {
		System.out.println("in ctor of "+getClass().getName());
		
	}
	//add req handling method to display vendor details
	@GetMapping("/details")
	public String showVendorDetails()
	{
		System.out.println("in show vendor details ");
		return "/vendor/details";
	}

}
