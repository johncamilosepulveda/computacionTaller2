package com.icesi.edu.co.jcss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icesi.edu.co.jcss.model.TsscAdmin;
import com.icesi.edu.co.jcss.services.IServiceAdmin;

@Controller
public class AdminController {

	IServiceAdmin adminService;

	@Autowired
	public AdminController(IServiceAdmin adminService) {
		this.adminService = adminService;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute("signupForm") TsscAdmin signupForm) {
		adminService.signup(signupForm);
		return "redirect:/";
	}

}
