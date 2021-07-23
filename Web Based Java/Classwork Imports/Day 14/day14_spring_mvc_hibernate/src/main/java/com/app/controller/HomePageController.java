package com.app.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	public HomePageController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@RequestMapping("/")
	public String showHomePage() {
		System.out.println("in show hm page");
		return "/index";// logical view name , actual view name : /WEB-INF/views/index.jsp
	}
}
