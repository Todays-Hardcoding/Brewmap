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
	
	@Transactional
	public String join(User user) {
			try {
				validateDuplicateMember(user);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			userRepository.save(user);
			return user.getUserId();
	}
	
	
	//중복체크 id
	private void validateDuplicateMember(User user) throws IllegalAccessException {
		Optional<User> findUser = userRepository.findById(user.getUserId());
		if(!findAllUser().isEmpty()) {
			throw new IllegalAccessException("이미 존재하는 회원입니다.");
		}
	}
	
}
