package com.brew.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brew.domain.User;
import com.brew.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// 유저 전체조회
	public List<User> findAllUser() {
		return userRepository.findAll();
	}

	// 유저 id 조회
	public User findByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}
	
	@Transactional
	public void userUpdate(User user) {
		userRepository.save(user);
	}
	
	public void deleteUser(String userId) {
		userRepository.deleteById(userId);
	}
	
	public void delete(User user) {
		userRepository.delete(user);
	}
	
	public void insert(User user) {
		userRepository.save(user);
		
	};

	public User checkUser(String userId, String userPw) {
		return userRepository.checkUser(userId, userPw);
	}
<<<<<<< HEAD


=======
	
	// 유저 id 조회
	public User checkUserId(String userId) {
		return userRepository.checkUserId(userId);
	}
>>>>>>> branch 'main' of https://github.com/Todays-Hardcoding/Brewmap.git
}
