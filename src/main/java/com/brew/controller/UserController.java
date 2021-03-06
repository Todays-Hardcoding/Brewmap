package com.brew.controller;

import javax.servlet.http.HttpSession;

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

@Controller
@RequiredArgsConstructor
public class UserController {

	@Autowired
	private UserService userservice;

	@GetMapping("/userpage")
	public String userpage(HttpSession session) {
//		session.setAttribute("user", userservice.findByUserId("abc"));
		return "view/user/userpage";
	}

	@RequestMapping("/modify")
	public String usermodifypage() {
		return "view/user/usermodifypage";
	}

	@RequestMapping(value = "/modifyUserInfo", method = RequestMethod.POST)
	public String update(HttpSession session, @ModelAttribute User user) {
		
		userservice.userUpdate(user);

		User newuser = userservice.findByUserId(user.getUserId());
		System.out.println(newuser);


		session.setAttribute("user", newuser);
		return "view/user/userpage";
	}


	@RequestMapping(value = "/delete", method=RequestMethod.GET)
	public String delete(String userId, HttpSession session) {
		System.out.println(userId);
		
		userservice.deleteUser(userId);
		
		session.removeAttribute("user");
		System.out.println("유저가 여기에서 삭제 됐습니다");
		return "view/index";
	}
}
