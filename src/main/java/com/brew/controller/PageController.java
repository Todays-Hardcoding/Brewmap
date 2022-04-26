package com.brew.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("/footer3")
	public String footer3() {
		return "view/pages/chat";
	}
	
	@RequestMapping("/login")
	public String loginnav() {
		return "view/login";
	}
	
	@RequestMapping("/mypage")
	public String mypagenav() {
		return "view/pages/mypage";
	}
}