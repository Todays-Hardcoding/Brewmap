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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
<<<<<<< HEAD
@ToString
=======
@DynamicUpdate
>>>>>>> origin/woo
public class User {
	@OneToMany(mappedBy = "user")
	private List<Board> board;

<<<<<<< HEAD
=======
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
	public void createDate() {
=======
	public void createdAt() {
>>>>>>> origin/woo
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

	@Builder
	public User(@NotNull String userCategory, @NotNull String userId, @NotNull String userPw, @NotNull String userName,
			@NotNull String userTel, @NotNull String userEmail, @NotNull String userGrade, @NotNull String userRegDate,
			@NotNull String userBirthDate, @NotNull String userNickName, @NotNull boolean userGender, String userCoupon,
			int userPoint, String userQuestion, String userAnswer) {
=======
=======
>>>>>>> origin/woo
	
	@Builder
	public User(List<Board> board, @NotNull String userCategory, @NotNull String userId, @NotNull String userPw,
			@NotNull String userName, @NotNull String userTel, @NotNull String userEmail, @NotNull String userGrade,
			LocalDateTime userRegDate, @NotNull String userBirthDate, @NotNull String userNickName,
<<<<<<< HEAD
			@NotNull boolean userGender, String userCoupon, String userPoint, String userQuestion, String userAnswer) {
>>>>>>> origin/jinho_branch
=======
			@NotNull boolean userGender, String userCoupon, int userPoint, String userQuestion, String userAnswer) {
>>>>>>> origin/woo
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
=======
>>>>>>> origin/woo

}
=======
	

}
>>>>>>> origin/jinho_branch
