package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.User;
import com.app.service.IVendorService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	// dependency
	@Autowired
	private IVendorService vendorService;

	public AdminController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// add req handling method to forward clnt to admin list page (showing vendor
	// list)
	@GetMapping("/list")
	public String showVendorList(Model map) {
		System.out.println("in show vendor list");
		map.addAttribute("vendor_list", vendorService.listVendors());
		return "/admin/list";// Actual view name : /WEB-INF/views/admin/list.jsp

	}

	// add req handling method to delete vendor details
	@GetMapping("/delete")
	public String deleteVendorDetails(@RequestParam int vid, RedirectAttributes flashMap) {
		System.out.println("in del vendor dtls " + vid + " " + flashMap);
		// invoke service layer method , get the result(mesg) n add it under flash scope
		flashMap.addFlashAttribute("message", vendorService.deleteVendorDetails(vid));
		return "redirect:/admin/list";

	}

	// add req handling method , to show vendor reg form
	@GetMapping("/register")
	// data binding Step 1 : POJO(Model) ---> Form(view layer): model attribute
	public String showVendorRegForm(User details) {
		//SC : modelMap.addAttribute("user",new User());
		System.out.println("in show vendor reg form " +details);//default POJO state
		// add EMPTY POJO instance(via def constr) under Model attribute map
	//	map.addAttribute("vendor_details", new User());// populated
	//	System.out.println("in show vendor reg form " + map);
		return "/admin/register";// Actual view name : /WEB-INF/views/admin/register.jsp
	}

	// add req handling method to process vendor reg form
	@PostMapping("/register")
	public String processVendorRegForm( User vendorDetails,
			RedirectAttributes flashMap) {
		System.out.println("in process v reg form " + vendorDetails);//vendorDetails : populated state loaded from form data.
		// invoke service layer method for saving vendor details
		flashMap.addFlashAttribute("message", vendorService.registerNewVendor(vendorDetails));
		return "redirect:/admin/list";
	}
	//add req handling method to show update form
	@GetMapping("/update")
	public String showVendorUpdateForm(@RequestParam int vid,Model map)
	{
		System.out.println("in show update form "+vid+" "+map);
		//invoke service layer method , get detached POJO from service layer n bind it to form data
		map.addAttribute("user",vendorService.getVendorDetails(vid));
		return "/admin/update";
	}
	//add req handling method for processing update form
	@PostMapping("/update")
	public String processUpdateForm(User vendor,RedirectAttributes flashMap)
	{
		System.out.println("process update form "+vendor);//vendor : DETACHED POJO containing updated state
		flashMap.addFlashAttribute("message", vendorService.updateVendorDetails(vendor));
		return "redirect:/admin/list";
	}
}
