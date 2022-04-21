package com.brew.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.brew.domain.User;
import com.brew.domain.User.UserBuilder;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public User findByUserId(String userId);

	

//	@Query(value="Update user set userId = :userId where userId = :userId ")
//	public User changeByUserId(@Param("userId") String userId);
	
//	@Query(value="update User u set u.name = :#{#user.name} WHERE u.no = :#{#user.no}", nativeQuery=false)
//	Integer update(@Param("user") User user );
//
//	@Modifying
//	@Transactional 
//	@Query(value = "Update  user u set u.userId = :#{#user.userId}, "
//			+ "u.userName = :#{#user.userName}, "
//			+ "u.userBirthDate = :#{#user.userBirthDate}, " 
//			+ "u.userGrade = :#{#user.userGrade},"
//			+ "u.userTel = :#{#user.userTel}, " 
//			+ "u.userEmail = :#{#user.userEmail} "
//			+ "where u.userId = :#{#user.userId}", nativeQuery = false)
//	int changeByUserId(@Param(value = "user") User user);
}
