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
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
@DynamicUpdate
public class Review {
	
	@NotNull
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="store_code")
	private StoreInfo storeInfo;

	@NotNull
	@ManyToOne
	@JsonBackReference
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
	
	@PrePersist
	@PreUpdate
	 public void createdAt() {
		this.reviewDate = LocalDateTime.now();
	 }
	
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

	@Override
	public String toString() {
		return "Review [storeInfo=" + storeInfo + ", user=" + user + ", reviewId=" + reviewId + ", reviewStar="
				+ reviewStar + ", reviewComment=" + reviewComment + ", reviewDate=" + reviewDate + "]";
	}

	

}
