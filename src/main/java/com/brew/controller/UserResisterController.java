package com.brew.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		return "view/signUp2";
	}
	
	@RequestMapping(value = "/signUp2")
	public String resisterUser(HttpServletRequest req, HttpServletResponse resp, @ModelAttribute User user) {
		
		user.setUserCategory(req.getParameter("userCategory"));
		user.setUserId(req.getParameter("userId"));
		user.setUserPw(req.getParameter("userPw"));
		user.setUserName(req.getParameter("userName"));
		user.setUserNickName(req.getParameter("userNickName"));
		user.setUserBirthDate(req.getParameter("userBirthDate"));
		user.setUserGrade(req.getParameter("userGrade"));
		user.setUserEmail(req.getParameter("userEmail"));
		user.setUserTel(req.getParameter("userTel"));
		userservice.userUpdate(user);
		// 보내온 value 가 0 이면 user.isUserGender() ==  true
		return "view/index";
	}
	
	
	@RequestMapping("/login")
	public String loginpage() {
		return "view/login";
	}
	
//	@RequestMapping(value="/login2")
//	public String login(HttpServletRequest req, HttpSession session, @ModelAttribute User user) {
//		
//		
//		User checkuser = userservice.checkUser(req.getParameter("userId"), req.getParameter("userPw"));
//		
//		if(checkuser != null) {
//			//	DB에서 userId로 받아온 파라미터 값을 user에 넣고 session에 등록 시킴
//			session.setAttribute("user",userservice.findByUserId(req.getParameter("userId")));
//		}else {
//			return "view/login";
//		}
//		
//		System.out.println(userservice.findByUserId(user.getUserId()));
//		System.out.println(req.getParameter("userId"));
//		return "view/index";
//	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "view/index";
	}
	
	

}
