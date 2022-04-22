package com.brew.repository;

<<<<<<< HEAD

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brew.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
   
   public User findByUserId(String userId);
   public User findByUserName(String userName);
   public User findByUserBirthDate(String userBirthDate);
   public User findByUserGrade(String userGrade);
   public User findByUserTel(String userTel);
   public User findByUserEmail(String userEmail);
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brew.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	
	public User findByUserId( String userId);

	public User findByUserName(String userName);

	public User findByUserBirthDate(String userBirthDate);

	public User findByUserGrade(String userGrade);

	public User findByUserTel(String userTel);

	public User findByUserEmail(String userEmail);
	
	
//	@Query(value="Update user set userId = :userId where userId = :userId ")
//	public User changeByUserId(@Param("userId") String userId);

>>>>>>> branch 'main' of https://github.com/Todays-Hardcoding/Brewmap.git

}