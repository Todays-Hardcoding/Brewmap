package com.brew.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Board {
	
	@Id
	@NotNull
	@Column
	private String postId;
	
	@NotNull
	@Column
	private String postTitle;
	
	@NotNull
	@Column
	private String postContent;
	
	@Column
	private LocalDateTime postDate;
	
	@Column
	private int postViews;
	
	@NotNull
	@Column
	private String boardId;
	
	@NotNull
	@Column
	private String userId;
	
	@Column
	private Integer postLike;
	
	@NotNull
	@Column
	private boolean postLikebook;

	@Builder
	public Board(String postId, String postTitle, String postContent, LocalDateTime postDate, int postViews,
			String boardId, String userId, Integer postLike, boolean postLikebook) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postDate = postDate;
		this.postViews = postViews;
		this.boardId = boardId;
		this.userId = userId;
		this.postLike = postLike;
		this.postLikebook = postLikebook;
	}	
	
}
