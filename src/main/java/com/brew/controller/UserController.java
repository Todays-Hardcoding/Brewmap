package com.brew.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brew.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	@Autowired
   private UserService userservice;
   
   // session에 들어있는 값을 repository에서 가져와서 setAttribute 시켜준다
   // submit 버튼 눌렀을때 get -> set
   
   
   @GetMapping("/userpage")
   public String userpage(Model model, HttpSession session) {
      
      
      //로그인 후 session 값
      String userId = "abcdf";
//      String userPw = "123456";
      String userName = "홍길동이";
      String userBirthDate = "19990124";
      String userGrade = "골드";
      String userTel = "010-1111-1111";
      String userEmail = "abcd@naver.com";
      
      session.setAttribute("userId", userId);
      session.setAttribute("userName", userName);
      session.setAttribute("userBirthDate", userBirthDate);
      session.setAttribute("userGrade", userGrade);
      session.setAttribute("userTel", userTel);
      session.setAttribute("userEmail", userEmail);
   
      
      model.addAttribute("user", userservice.findByUserId("abc"));
      model.addAttribute("user", userservice.findByUserName("홍길동"));
      model.addAttribute("user", userservice.findByUserBirthDay("19940714"));
      model.addAttribute("user", userservice.findByUserGrade("브론즈"));
      model.addAttribute("user", userservice.findByUserTel("010-1234-5678"));
      model.addAttribute("user", userservice.findByUserEmail("abc@naver.com"));
      
      model.addAttribute("userList", userservice.findAllUser());
      
      //session.setAttribute("userId", userservice.getUser(user.getUserId()));
      //session.setAttribute("userName", userservice.findAllUser());
      
//      System.out.println(userservice.findAll());
      return "view/pages/userpage";
   }
   

   @RequestMapping("/modify")
   public String usermodifypage(Model model) {
      
      model.addAttribute("user", userservice.findByUserId("abc"));
      model.addAttribute("user", userservice.findByUserName("홍길동"));
      model.addAttribute("user", userservice.findByUserBirthDay("19940714"));
      model.addAttribute("user", userservice.findByUserGrade("브론즈"));
      model.addAttribute("user", userservice.findByUserTel("010-1234-5678"));
      model.addAttribute("user", userservice.findByUserEmail("abc@naver.com"));
      return "view/pages/usermodifypage";
   }
   
   
   
   
//   String userId = "abc";
//   String userPw = "1234";
//   String userName = "홍길동";
//   String userBirthDay = "20220420";
//   String userGrade = "골드";
//   String userTel = "010-1111-1111";
//   String userEmail = "abc@naver.com";
//   
//   session.setAttribute("userId", userId);
//   session.setAttribute("userPw", userPw);
//   session.setAttribute("userName", userName);
//   session.setAttribute("userBirthDay", userBirthDay);
//   session.setAttribute("userGrade", userGrade);
//   session.setAttribute("userTel", userTel);
//   session.setAttribute("userEmail", userEmail);
   

}