package com.brew.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Reply {
	
	@NotNull
	@Column
	@ManyToOne
	@JoinColumn(name = "post_id", referencedColumnName = "post_id" )
	private String postId;
	
	@Id
	@NotNull
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String replyId;
	
	@NotNull
	@Column
	private String replyContent;
	
	@NotNull
	@Column
	private String replyUser;
	
	@Column
	private String replyDate;
	
	@Column
	private Integer replyLikeCount;

	@Builder
	public Reply(@NotNull String postId, @NotNull String replyId, @NotNull String replyContent,
			@NotNull String replyUser, String replyDate, Integer replyLikeCount) {
		super();
		this.postId = postId;
		this.replyId = replyId;
		this.replyContent = replyContent;
		this.replyUser = replyUser;
		this.replyDate = replyDate;
		this.replyLikeCount = replyLikeCount;
	}
	
	

}
