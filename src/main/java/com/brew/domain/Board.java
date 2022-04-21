<<<<<<< HEAD
package com.brew.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "board")
	private List<Reply> reply;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Id
	@NotNull
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String boardId;
	
	@NotNull
	@Column
	private String boardTitle;
	
	@NotNull
	@Column
	private String boardContent;
	
	@Column
	private LocalDateTime boardDate;
	
	@Column
	private Integer boardViews;
	
	@NotNull
	@Column
	private String boardCategory;
	
	@Column
	private Integer boardLikeCount;

	@Builder
	public Board(@NotNull String boardId, @NotNull String boardTitle, @NotNull String boardContent, LocalDateTime boardDate,
			Integer boardViews, @NotNull String boardCategory, Integer boardLikeCount) {
		super();
		this.boardId = boardId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardViews = boardViews;
		this.boardCategory = boardCategory;
		this.boardLikeCount = boardLikeCount;
	}	
}
=======
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
>>>>>>> branch 'jinho_branch' of https://github.com/Todays-Hardcoding/Brewmap.git
