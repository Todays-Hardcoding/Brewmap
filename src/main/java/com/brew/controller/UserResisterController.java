package com.brew.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brew.domain.User;
import com.brew.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserResisterController {

	@Autowired
	private UserService userservice;
	
	@RequestMapping("/signUp")
	public String userSignUp() {
		return "view/signUp";
	}
	
	@RequestMapping(value = "/signUpPage")
	public String userResister(HttpServletRequest req, @ModelAttribute User user) {
		userservice.userUpdate(user);
		return "view/index";
	}
	
	@GetMapping(value = "/dupUser")
	@ResponseBody
	public Map<String, Integer> userCheck(HttpServletRequest req, @RequestParam("id") String id) {
		User idCheck = userservice.checkUserId(id);
	
		Map<String, Integer> result = new HashMap<String, Integer>();
		 if( idCheck != null || id.length() < 4) {
			 result.put("result", 0);
		 }else {
			 result.put("result", 1);
		 }
		return result;
	}
	
	
	@RequestMapping("/login")
	public String loginPage() {
		return "view/login";
	}
	
	@RequestMapping(value="/loginPage")
	public String userLogin(HttpServletRequest req, HttpSession session, @ModelAttribute User user) {
		
		User checkuser = userservice.checkUser(req.getParameter("userId"), req.getParameter("userPw"));

		if(checkuser != null) {
			session.setAttribute("user",userservice.findByUserId(req.getParameter("userId")));
		}else {
			return "view/login";
		}
		return "view/index";
	}
	
	@RequestMapping("logout")
	public String userLogout(HttpSession session) {
		session.removeAttribute("user");
		return "view/index";
	}
	
}
