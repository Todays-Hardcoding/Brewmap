package com.brew.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table
public class Review {
	
	@ManyToOne
	@JoinColumn(name="store_code")
	private StoreInfo storeInfo;

	 @PrePersist 
	 public void createdAt() {
	 storeInfo.setReviewCount(storeInfo.getReview().size()); 
	 this.reviewDate = LocalDateTime.now();
	 }

	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Id
	@NotNull
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reviewId;
	
	@NotNull
	@Column
	private int reviewStar;
	
	@NotNull
	@Column
	private String reviewComment;
	
	@Column
	private LocalDateTime reviewDate;
	
	@Builder
	public Review(StoreInfo storeInfo, User user, @NotNull long reviewId, @NotNull int reviewStar,
			@NotNull String reviewComment, LocalDateTime reviewDate) {
		super();
		this.storeInfo = storeInfo;
		this.user = user;
		this.reviewId = reviewId;
		this.reviewStar = reviewStar;
		this.reviewComment = reviewComment;
		this.reviewDate = reviewDate;
	}

	
	
	
	
}