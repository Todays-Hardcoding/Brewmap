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

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
@DynamicUpdate
public class Reply {
	
	@NotNull
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="board_id")
	private Board board;
	
	@NotNull
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="user_id")
	private User user;
	
	@Id
	@NotNull
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long replyId;
	
	@NotNull
	@Column
	private String replyContent;
	
	@Column 
	private LocalDateTime replyDate;
	
	@Column
	private Integer replyLikeCount;
	
	@PrePersist
	@PreUpdate
	public void createdAt() {
		this.replyDate = LocalDateTime.now();
	}

	@Builder
	public Reply(Board board, User user, @NotNull long replyId, @NotNull String replyContent, LocalDateTime replyDate,
			Integer replyLikeCount) {
		super();
		this.board = board;
		this.user = user;
		this.replyId = replyId;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.replyLikeCount = replyLikeCount;
	}
}