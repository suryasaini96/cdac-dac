package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

	public HomePageController() {
		System.out.println("In default constructor : " + getClass().getName());
	}
	
	@RequestMapping("/")
	public String showHomePage() {
		System.out.println("In show home page...");
		return "/index";
	}
}
