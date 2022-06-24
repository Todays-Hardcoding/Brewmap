package com.brew.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/footer3")
	public String footer3() {
		return "view/pages/chat";
	}

}