package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	public HomePageController() {
		System.out.println("in ctor of "+getClass().getName());
	}
	//add a req handling method to forward the user to index page
	@RequestMapping("/")
	public String showHomePage()
	{
		System.out.println("in show hm page");
		return "/index";//Actual view name : /WEB-INF/views/index.jsp
	}
}
