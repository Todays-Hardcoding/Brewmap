package com.brew.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
import groovy.transform.ToString;
>>>>>>> origin/GY
import lombok.Builder;
=======
import groovy.transform.ToString;
import lombok.Builder;
import lombok.Data;
>>>>>>> origin/jinho_branch
=======
import org.hibernate.annotations.DynamicUpdate;

import lombok.Builder;
>>>>>>> origin/woo
=======
import groovy.transform.ToString;
import lombok.Builder;
import lombok.Data;
>>>>>>> origin/Jinhwan
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
@ToString
=======
@DynamicUpdate
>>>>>>> origin/woo
=======
@ToString
>>>>>>> origin/Jinhwan
=======
@ToString
>>>>>>> origin/GY
public class User {
	@OneToMany(mappedBy = "user")
	private List<Board> board;

<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> origin/Jinhwan
	@OneToMany(mappedBy = "user")
	private List<Review> Review;
	
>>>>>>> origin/jinho_branch
	@NotNull
	@Column
	private String userCategory;
	@Id
	@NotNull
	@Column
	private String userId;
	@NotNull
	@Column
	private String userPw;
	@NotNull
	@Column
	private String userName;
	@NotNull
	@Column
	private String userTel;
	@NotNull
	@Column
	private String userEmail;
	@NotNull
	@Column
	private String userGrade;
	@Column
	private LocalDateTime userRegDate;
	@PrePersist
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	public void createDate() {
=======
	public void createdAt() {
>>>>>>> origin/woo
=======
	public void createDate() {
>>>>>>> origin/Jinhwan
=======
	public void createDate() {
>>>>>>> origin/GY
		this.userRegDate = LocalDateTime.now();
	}
	@NotNull
	@Column
	private String userBirthDate;
	@NotNull
	@Column
	private String userNickName;
	@NotNull
	@Column
	private boolean userGender;
	@Column
	private String userCoupon;
	@Column
	private String userPoint;
	@Column
	private String userQuestion;
	@Column
	private String userAnswer;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

	@Builder
	public User(@NotNull String userCategory, @NotNull String userId, @NotNull String userPw, @NotNull String userName,
			@NotNull String userTel, @NotNull String userEmail, @NotNull String userGrade, @NotNull String userRegDate,
			@NotNull String userBirthDate, @NotNull String userNickName, @NotNull boolean userGender, String userCoupon,
			int userPoint, String userQuestion, String userAnswer) {
=======
=======
>>>>>>> origin/woo
=======
>>>>>>> origin/Jinhwan
	
	@Builder
	public User(List<Board> board, @NotNull String userCategory, @NotNull String userId, @NotNull String userPw,
			@NotNull String userName, @NotNull String userTel, @NotNull String userEmail, @NotNull String userGrade,
			LocalDateTime userRegDate, @NotNull String userBirthDate, @NotNull String userNickName,
<<<<<<< HEAD
<<<<<<< HEAD
			@NotNull boolean userGender, String userCoupon, String userPoint, String userQuestion, String userAnswer) {
>>>>>>> origin/jinho_branch
=======
			@NotNull boolean userGender, String userCoupon, int userPoint, String userQuestion, String userAnswer) {
>>>>>>> origin/woo
=======
			@NotNull boolean userGender, String userCoupon, String userPoint, String userQuestion, String userAnswer) {
>>>>>>> origin/Jinhwan
=======
	
	@Builder
	public User(List<Board> board, @NotNull String userCategory, @NotNull String userId, @NotNull String userPw,
			@NotNull String userName, @NotNull String userTel, @NotNull String userEmail, @NotNull String userGrade,
			LocalDateTime userRegDate, @NotNull String userBirthDate, @NotNull String userNickName,
			@NotNull boolean userGender, String userCoupon, String userPoint, String userQuestion, String userAnswer) {
>>>>>>> origin/GY
		super();
		this.board = board;
		this.userCategory = userCategory;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userTel = userTel;
		this.userEmail = userEmail;
		this.userGrade = userGrade;
		this.userRegDate = userRegDate;
		this.userBirthDate = userBirthDate;
		this.userNickName = userNickName;
		this.userGender = userGender;
		this.userCoupon = userCoupon;
		this.userPoint = userPoint;
		this.userQuestion = userQuestion;
		this.userAnswer = userAnswer;
	}
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/woo
=======
	
>>>>>>> origin/Jinhwan
=======
	
>>>>>>> origin/GY

}
=======
	

}
>>>>>>> origin/jinho_branch
