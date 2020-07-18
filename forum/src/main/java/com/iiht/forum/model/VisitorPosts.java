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
//@Table(name = "postdata")
@Document("postdata")
@Data
public class VisitorPosts 
{
	@Id
	private String id;
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "postid")
	
//	@Column(name = "title")
	private String title;
	
//	@Column(name = "tags")
	private String tags;
	
//	@Column(name = "postDescription")
	private String postDescription;
	
//	@OneToMany(mappedBy="Posts", cascade = CascadeType.ALL)
//  @OneToMany(cascade = CascadeType.ALL)
//  @JoinColumn(name="postId")
//  private Set<VisitorComments> Comments;

//	@OneToMany(fetch=FetchType.EAGER)
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="postId")
//	private Set<VisitorComments> comments;
  
	public VisitorPosts() {
		super();
	}

	public VisitorPosts(String id, String title, String tags, String postDescription) {
		super();
		this.id = id;
		this.title = title;
		this.tags = tags;
		this.postDescription = postDescription;
	}

	/*
	 * public String getId() { return id; }
	 * 
	 * public void setId(String id) { this.id = id; }
	 * 
	 * public String getTitle() { return title; }
	 * 
	 * public void setTitle(String title) { this.title = title; }
	 * 
	 * public String getTags() { return tags; }
	 * 
	 * public void setTags(String tags) { this.tags = tags; }
	 * 
	 * public String getPostDescription() { return postDescription; }
	 * 
	 * public void setPostDescription(String postDescription) { this.postDescription
	 * = postDescription; }
	 */
}