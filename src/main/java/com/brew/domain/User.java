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

import groovy.transform.ToString;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
@ToString
public class User {
	@OneToMany(mappedBy = "user")
	private List<Board> board;

	@OneToMany(mappedBy = "user")
	private List<Review> review;
	
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
	public void createDate() {
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
	
	@Builder
	public User(List<Board> board, @NotNull String userCategory, @NotNull String userId, @NotNull String userPw,
			@NotNull String userName, @NotNull String userTel, @NotNull String userEmail, @NotNull String userGrade,
			LocalDateTime userRegDate, @NotNull String userBirthDate, @NotNull String userNickName,
			@NotNull boolean userGender, String userCoupon, String userPoint, String userQuestion, String userAnswer) {
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
	

}
