package com.brew.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Review {
	
	@ManyToOne
	@JoinColumn(name="store_code")
	@JsonBackReference
	private StoreInfo storeInfo;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonBackReference
	private User user;
	
	@Id
	@NotNull
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reviewId;
	
	@NotNull
	@Column
	private String reviewUser;
	
	@NotNull
	@Column
	private int reviewStar;
	
	@NotNull
	@Column
	private String reviewComment;
	
	@Column
	private LocalDateTime reviewDate;
	
	@PrePersist
	public void createdAt() {
		this.reviewDate = LocalDateTime.now();
	}
	
	@Builder
	public Review(StoreInfo storeInfo, User user, @NotNull long reviewId, @NotNull String reviewUser,
			@NotNull int reviewStar, @NotNull String reviewComment, LocalDateTime reviewDate) {
		super();
		this.storeInfo = storeInfo;
		this.user = user;
		this.reviewId = reviewId;
		this.reviewUser = reviewUser;
		this.reviewStar = reviewStar;
		this.reviewComment = reviewComment;
		this.reviewDate = reviewDate;
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/Jinhwan
