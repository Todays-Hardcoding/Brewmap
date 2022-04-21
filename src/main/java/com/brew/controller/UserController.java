package com.brew.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brew.domain.User;
import com.brew.repository.UserRepository;
import com.brew.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	@Autowired
	private UserService userservice;

	@GetMapping("/userpage")
	public String userpage(Model model, HttpSession session) {
		session.setAttribute("user", userservice.findByUserId("ab"));
		return "view/pages/userpage";
	}

	@RequestMapping("/modify")
	public String usermodifypage(Model model) {
		return "view/pages/usermodifypage";
	}

   @RequestMapping(value="/modifyUserInfo",method=RequestMethod.POST)
   public String update(Model model, HttpSession session,@ModelAttribute User user) {
	   userservice.userUpdate(user);
	   User newuser = userservice.findByUserId(user.getUserId());
	   System.out.println(newuser);
	   
	   session.setAttribute("user", newuser);
		return "view/pages/userpage";
   }
   // input 태그안에 name에 들어있는 값이  key!!  //// value Attribute안에 있는 값이 value
   
//	@RequestMapping("/modifyUserInfo")
//	public String update(@RequestBody User user) {
//		User newuser = userservice.userUpdate(user);
//		
//		System.out.println(newuser);
//		return "view/pages/userpage";
//	}
//
//	@RequestMapping("/modifyUserInfo")
//	public String modify(@RequestParam(required = false) String userId, Model model) {
//		userservice.save(userId);
//		model.addAttribute("user", userservice.findByUserId("ab"));
//		return "view/pages/userpage";
//	}

//   @PostMapping("/modifyUserInfo")
//   public String save(User user) {
//	   userservice.saveUser(user.getUserId());
//	   return "view/pages/userpage";
//   }

//   @PostMapping("/modifyUserInfo")
//   public String modifySubmit(Model model,HttpSession session) {
//	   session.setAttribute("user", userservice.modifyByUserId("userId", "userName", "userBirthDate", "userGrade", "userTel", "userEmail"));	   
//	   return "view/pages/userpage";
//   }

//   @PostMapping("/modifyUserInfo")
//   public String modifySubmit(Model model,HttpSession session, User user) {
//	   session.setAttribute("user", userservice.modifyByUserId(user));	   
//	   return "view/pages/userpage";
//   }

}
