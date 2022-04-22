package com.brew.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	private StoreInfo storeInfo;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Id
	@NotNull
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String reviewId;
	
	@NotNull
	@Column
	private int reviewStar;
	
	@NotNull
	@Column
	private String reviewComment;
	
	@Column
	private LocalDateTime reviewDate;

	@Builder
	public Review(@NotNull String reviewId, @NotNull int reviewStar, @NotNull String reviewComment,
			LocalDateTime reviewDate) {
		super();
		this.reviewId = reviewId;
		this.reviewStar = reviewStar;
		this.reviewComment = reviewComment;
		this.reviewDate = reviewDate;

	}
	
}