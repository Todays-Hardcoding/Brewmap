package com.brew.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private int boardViews;
	
	@NotNull
	@Column
	private String boardCategory;
	
	@NotNull
	@Column
	private String userId;
	
	@Column
	private Integer boardLikeCount;

	@Builder
	public Board(@NotNull String boardId, @NotNull String boardTitle, @NotNull String boardContent, LocalDateTime boardDate,
			int boardViews, @NotNull String boardCategory, @NotNull String userId, Integer boardLikeCount) {
		super();
		this.boardId = boardId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardViews = boardViews;
		this.boardCategory = boardCategory;
		this.userId = userId;
		this.boardLikeCount = boardLikeCount;
	}	
}
