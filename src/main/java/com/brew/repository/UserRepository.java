package com.brew.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.brew.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public User findByUserId(String userId);
	public User UserId(User userId);

	@Query("SELECT u FROM User u WHERE u.userId = :userId and u.userPw = :userPw")
	public User checkUser(@Param("userId") String id, @Param("userPw") String pw);
	
	@Query("SELECT u FROM User u WHERE u.userId = :userId")
	public User checkUserId(@Param("userId") String id);

}
