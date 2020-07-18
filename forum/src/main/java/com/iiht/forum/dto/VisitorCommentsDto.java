package com.iiht.forum.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class VisitorCommentsDto
{
	private String id;

	private String postId;

	@NotNull
	@Length(min = 1, max = 50)
	private String tags;
	
	@NotNull
	@Length(min = 1, max = 500)
	private String comment;
	
	public VisitorCommentsDto() {
		super();
	}

	public VisitorCommentsDto(String postId, String id, String tags, String comment) {
		super();
		this.id = id;
		this.postId = postId;
		this.tags = tags;
		this.comment = comment;
	}
	 
	/*
	 * public Long getPostId() { return postId; }
	 * 
	 * public void setPostId(Long postId) { this.postId = postId; }
	 * 
	 * public Long getCommentId() { return commentId; }
	 * 
	 * public void setCommentId(Long commentId) { this.commentId = commentId; }
	 * 
	 * public String getTags() { return tags; }
	 * 
	 * public void setTags(String tags) { this.tags = tags; }
	 * 
	 * public String getComment() { return comment; }
	 * 
	 * public void setComment(String comment) { this.comment = comment; }
	 */
	 
}