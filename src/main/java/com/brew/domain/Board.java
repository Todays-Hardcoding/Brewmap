package com.brew.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	private Integer postLikeCount;

	@Builder
	public Board(@NotNull String postId, @NotNull String postTitle, @NotNull String postContent, LocalDateTime postDate,
			int postViews, @NotNull String boardId, @NotNull String userId, Integer postLikeCount) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postDate = postDate;
		this.postViews = postViews;
		this.boardId = boardId;
		this.userId = userId;
		this.postLikeCount = postLikeCount;
	}	
}
