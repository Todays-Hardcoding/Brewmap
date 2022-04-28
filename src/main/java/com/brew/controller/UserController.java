package com.brew.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String userPage(HttpSession session) {
		return "view/user/userpage";
	}

	@RequestMapping("/modify")
	public String userModifyPage() {
		return "view/user/usermodifypage";
	}

	@RequestMapping(value = "/modifyUserInfo", method = RequestMethod.POST)
	public String userUpdate(HttpSession session, @ModelAttribute User user) {
		userservice.userUpdate(user);

		User newuser = userservice.findByUserId(user.getUserId());

		session.setAttribute("user", newuser);
		return "view/user/userpage";
	}

	@RequestMapping(value = "/delete", method=RequestMethod.GET)
	public String userDelete(String userId, HttpSession session) {
		userservice.deleteUser(userId);
		
		session.removeAttribute("user");
		return "view/index";
	}
}
