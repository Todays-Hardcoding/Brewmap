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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import groovy.transform.ToString;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table
@DynamicUpdate
public class Board {

	@OneToMany(mappedBy = "board")
	@JsonManagedReference
	private List<Reply> reply;

	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonBackReference
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

	@Column
	private LocalDateTime boardDate;

	@Column
	private Integer boardViews;

	@NotNull
	@Column
	private String boardCategory;

	@Column
	private Integer boardLikeCount;

	@PrePersist
	@PreUpdate
	public void createdAt() {
		this.boardDate = LocalDateTime.now();
		this.boardLikeCount = 0;
	}

	@Builder
	public Board(List<Reply> reply, User user, @NotNull long boardId, @NotNull String boardTitle,
				 @NotNull String boardContent, LocalDateTime boardDate, Integer boardViews, @NotNull String boardCategory,
				 Integer boardLikeCount) {
		super();
		this.reply = reply;
		this.user = user;
		this.boardId = boardId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardViews = boardViews;
		this.boardCategory = boardCategory;
		this.boardLikeCount = boardLikeCount;
	}
}