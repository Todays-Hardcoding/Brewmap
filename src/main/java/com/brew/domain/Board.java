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

import org.hibernate.annotations.CreationTimestamp;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long boardId;
	
	@NotNull
	@Column
	private String boardTitle;
	
	@NotNull
	@Column
	private String boardContent;
	
	@Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
	private LocalDateTime boardDate;
	
	@Column
	private Integer boardViews;
	
	@NotNull
	@Column
	private String boardCategory;
	
	@Column
	private Integer boardLikeCount;

	@Builder
	public Board(@NotNull long boardId, @NotNull String boardTitle, @NotNull String boardContent, LocalDateTime boardDate,
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
