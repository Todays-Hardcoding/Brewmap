package com.brew.service;

import java.util.List;

import javax.transaction.Transactional;

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
	
}