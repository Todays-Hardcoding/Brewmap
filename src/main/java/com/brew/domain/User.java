package com.brew.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table
@DynamicUpdate
public class User {
	
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private List<Board> board;

	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private List<Review> Review;

	@NotNull
	@Column
	private String userCategory;
	
	@Id
	@NotNull
	@Column
	@NotBlank(message="아이디는필수값")
	private String userId;
	
	@NotNull
	@Column
	@NotBlank(message="비밀번호는 필수값")
	@Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{4,20}",
    message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 4자 ~ 20자의 비밀번호여야 합니다.")
	private String userPw;
	
	@NotNull
	@Column
	private String userName;
	
	@NotNull
	@Column
	private String userTel;
	
	@NotNull
	@Column
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식에 맞지 않습니다.")
	private String userEmail;
	
	@NotNull
	@Column
	private String userGrade;
	
	@Column
	private LocalDateTime userRegDate;

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
	
	@PrePersist
	@PreUpdate
	public void createdAt() {
		this.userRegDate = LocalDateTime.now();
	}

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