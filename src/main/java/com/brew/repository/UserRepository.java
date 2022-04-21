package com.brew.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brew.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public User findByUserId(String userId);
	
}
