package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
//dependency 
	@Autowired
	private IUserService userService;
	public AdminController() {
		System.out.println("in ctor of "+getClass().getName());
	}
	//add new request handling method to list all vendors
	@GetMapping("/list")
	public String showVendors(Model map)
	{
		System.out.println("in show vendors "+map);
		map.addAttribute("vendor_list", userService.getAllVendors());
		return "/admin/list";//AVN : /WEB-INF/views/admin/list.jsp
	}
	//add new req handling method for deleting vendor details
	@GetMapping("/delete")
	public String deleteVendorDetails(@RequestParam int vid,RedirectAttributes flashMap)
	{
		System.out.println("in del vendor details "+vid);
		//invoke service layer
		flashMap.addFlashAttribute("message", userService.deleteVendorDetails(vid));
		return "redirect:/admin/list";//redirects the clnt :sends temp redirect resp
	}
	//add req handling method : for showing vendor reg form
	@GetMapping("/add")
	public String showAddNewVendorForm(User vendor) //POJO ---> Form data
	//SC creates vendor instance (def ctor) n adds the POJO in the Model map
	{
		System.out.println("in show vendor reg form "+vendor);
		return "/admin/add";//actual view name : /WEB-INF/views/admin/add.jsp
	}
	//add req handling method : for processing vendor reg form
	@PostMapping("/add")
	public String processAddVendorForm(User userDetails,RedirectAttributes flashMap) //Form data ---> POJO
	{
		System.out.println("in process vendor reg form "+userDetails);//populated POJO bound with form data
		//service layer call
		flashMap.addFlashAttribute("message", userService.registerVendor(userDetails));
		return "redirect:/admin/list";
	}
}
