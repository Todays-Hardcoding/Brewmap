package com.brew.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table
public class User {
	@OneToMany(mappedBy = "user")
	private List<Board> board;
	
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
	@NotNull
	@Column
	private String userRegDate;
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
	private int userPoint;
	@Column
	private String userQuestion;
	@Column
	private String userAnswer;
	
	
	
	
	public User(@NotNull String userCategory, @NotNull String userId, @NotNull String userPw, @NotNull String userName,
			@NotNull String userTel, @NotNull String userEmail, @NotNull String userGrade, @NotNull String userRegDate,
			@NotNull String userBirthDate, @NotNull String userNickName, @NotNull boolean userGender, String userCoupon,
			int userPoint, String userQuestion, String userAnswer) {
		super();
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
	
	
	
	
	
	
	
}
