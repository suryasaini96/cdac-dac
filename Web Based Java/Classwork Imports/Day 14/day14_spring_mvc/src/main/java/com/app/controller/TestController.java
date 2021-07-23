package com.app.controller;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // mandatory
@RequestMapping("/test") // optional BUT reco.
public class TestController {
	public TestController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@GetMapping("/test1") // =@RequestMapping : method=GET
	public ModelAndView testMe() {
		System.out.println("in test me");
		// return ModelAndView object wrapping logical view nm + model attribute/s
		// o.s.w.s.ModelAndView(String viewName,String modelAttrName,Object value)
		return new ModelAndView("/test/test1", "server_date", LocalDateTime.now());
		// Handler rets M&V to the D.S
		// logical view name : /test/test1 , actual view name reted by V.R (View
		// resolver)
		// /WEB-INF/views/test/test1.jsp
	}

	// add req handling method for storing results in the Model map
	@GetMapping("/test2")
	public String testModelMap(Model modelMap)//IoC
	{
		System.out.println("in test model map "+modelMap);//{} : empty Map
	    modelMap.addAttribute("server_date", LocalDateTime.now()).
	    addAttribute("num_list", Arrays.asList(10,20,30,40));
	    System.out.println("in test model map "+modelMap);//populated with 2 model attributes
		return "/test/test1";//Handler rets EXPLICITLY : logical view name to F.C
		//Handler IMPLICITLY rets entire Model Map to F.C
	}
}
