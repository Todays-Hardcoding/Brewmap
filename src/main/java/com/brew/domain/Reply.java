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
@ToString
@NoArgsConstructor
@Entity
@Table
@DynamicUpdate
public class Reply {
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="board_id")
	private Board board;
	
	@Id
	@NotNull
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long replyId;
	
	@NotNull
	@Column
	private String replyContent;
	
	@NotNull
	@Column
	private String replyUser;
	
	@Column 
	private LocalDateTime replyDate;
	
	@Column
	private Integer replyLikeCount;
	
	@PrePersist
	public void createdAt() {
		this.replyDate = LocalDateTime.now();
	}

	@Builder
	public Reply(Board board, @NotNull long replyId, @NotNull String replyContent, @NotNull String replyUser,
			LocalDateTime replyDate, Integer replyLikeCount) {
		super();
		this.board = board;
		this.replyId = replyId;
		this.replyContent = replyContent;
		this.replyUser = replyUser;
		this.replyDate = replyDate;
		this.replyLikeCount = replyLikeCount;
	}
	
}