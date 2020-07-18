package com.iiht.forum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

//@Entity
//@Table(name = "comments")
@Document("comments")
@Data
public class VisitorComments 
{
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "commentid")
	private String id;
	
//	@Column(name = "postid")
	private String postId;

//	@Column(name = "tags")
	private String tags;
	
//	@Column(name = "comment")
	private String comment;
	
	//@OneToMany(mappedBy="VistiorPosts",cascade=CascadeType.PERSIST)
	//private List<VisitorPosts> posts;
	
	public VisitorComments() {
		super();
	}

	public VisitorComments(String postId, String id, String tags, String comment) {
		super();
		this.id = id;
		this.postId = postId;
		this.tags = tags;
		this.comment = comment;
	}

	/*
	 * public String getPostId() { return postId; }
	 * 
	 * public void setPostId(String postId) { this.postId = postId; }
	 * 
	 * public String getId() { return id; }
	 * 
	 * public void setId(String id) { this.id = id; }
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