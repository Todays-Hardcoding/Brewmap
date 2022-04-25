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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@PrePersist
	public void createdAt() {
		this.boardDate = LocalDateTime.now();
		this.boardLikeCount = 0;
	}
	
	@Column
	private Integer boardViews;
	
	@NotNull
	@Column
	private String boardCategory;
	
	@Column
	private Integer boardLikeCount;

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
=======
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@PrePersist
	public void createdAt() {
		this.boardDate = LocalDateTime.now();
		this.boardLikeCount = 0;
	}
	
	@Column
	private Integer boardViews;
	
	@NotNull
	@Column
	private String boardCategory;
	
	@Column
	private Integer boardLikeCount;

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
>>>>>>> branch 'GY' of https://github.com/Todays-Hardcoding/Brewmap.git
