package com.brew.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/footer3")
	public String chat() {
		return "view/pages/chat";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "view/login";
	}
	
	@RequestMapping("/mypage")
	public String mypage() {
		return "view/pages/mypage";
	}
	// 방명록
	
	//수정
	//수정테스트 - 진환진환
	//수정테스트 - 진환

	//수정테스트 - 인혁
	
	
	// 수정테스트 - 진호 
	//수정테스트 - 경희pipi
	
	// 수정테스트 - 윤정

	//민아
	//수정테스트 - 건영
	//수정테스트 - 건영2
}