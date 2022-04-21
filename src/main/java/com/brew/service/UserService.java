package com.brew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brew.domain.User;
import com.brew.repository.UserRepository;

@Service
public class UserService {

   @Autowired
   private UserRepository userRepository;

   public List<User> findAllUser() {
      return userRepository.findAll();
   }
   public User findByUserId(String userId){
      return userRepository.findByUserId(userId);
   }
   public User findByUserName(String userName){
      return userRepository.findByUserName(userName);
   }
   public User findByUserBirthDay(String userBirthDate){
      return userRepository.findByUserBirthDate(userBirthDate);
   }
   public User findByUserGrade(String userGrade){
      return userRepository.findByUserGrade(userGrade);
   }
   public User findByUserTel(String userTel){
      return userRepository.findByUserTel(userTel);
   }
   public User findByUserEmail(String userEmail){
      return userRepository.findByUserEmail(userEmail);
   }
}