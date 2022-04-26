package com.brew.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brew.domain.User;
import com.brew.service.UserService;

import lombok.RequiredArgsConstructor;

// @RestController = Controller + ResponseBody(데이터 자체를 xml이나 json으로 보내자)
@Controller
@RequiredArgsConstructor
public class UserResisterController {

	@Autowired
	private UserService userservice;
	
	@RequestMapping("/signUp")
	public String usermodifypage() {
		
		return "view/signUp";
	}
	
	@RequestMapping(value = "/signUpPage")
	public String resisterUser(HttpServletRequest req, @ModelAttribute User user) {
		userservice.userUpdate(user);
		
		// 보내온 value 가 0 이면 user.isUserGender() ==  true
		return "view/index";
	}
	
	@RequestMapping(value = "/dupUser")
	public String checkUser(HttpServletRequest req, @RequestParam String result) {
		String checkUserId = req.getParameter("userId");
		User idCheck = userservice.checkUserId(checkUserId);
		
		 if( idCheck != null) {
			 result = "idChecked";
		 }else {
			 result = "idUnchecked";
		 }
		 req.setAttribute("result", result);
		return result;
	}
	
	
	
	@RequestMapping("/login")
	public String loginpage() {
		return "view/login";
	}
	
	@RequestMapping(value="/loginPage")
	public String login(HttpServletRequest req, HttpSession session, @ModelAttribute User user) {
		
		User checkuser = userservice.checkUser(req.getParameter("userId"), req.getParameter("userPw"));

		if(checkuser != null) {
			//	DB에서 userId로 받아온 파라미터 값을 user에 넣고 session에 등록 시킴
			session.setAttribute("user",userservice.findByUserId(req.getParameter("userId")));
		}else {
			return "view/login";
		}
		
		System.out.println(userservice.findByUserId(user.getUserId()));
		System.out.println(req.getParameter("userId"));
		return "view/index";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "view/index";
	}
	

}
