package com.brew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brew.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userservice;
	
	@GetMapping("/userpage")
	public String storeList(Model model) {
		model.addAttribute("userList", userservice.findAll());
		System.out.println(userservice.findAll());
		return "view/pages/userpage";
	}
	
	@RequestMapping("/userpage")
	public String mypage() {
		return "view/pages/userpage";
	}

}
