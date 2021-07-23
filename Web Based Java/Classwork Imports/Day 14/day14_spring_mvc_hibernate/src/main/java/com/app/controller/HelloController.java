package com.app.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // mandatory anno to tell SC :following is a spring bean : meant for req
			// handling.
//def scope : singleton
//def loading policy : eager
public class HelloController {
	public HelloController() {
		System.out.println("in ctor of " + getClass().getName());
	}
	//init style method
	@PostConstruct
	public void init()
	{
		System.out.println("in init");
	}
	//how to tell SC following is the req handling method
	@RequestMapping("/hello")
	public String sayHello()
	{
		System.out.println("in say hello");
		return "/welcome";//Handler rets a  logical view name to F.C
	}
	
	
}
