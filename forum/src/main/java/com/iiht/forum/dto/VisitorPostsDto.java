package com.iiht.forum.dto;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class VisitorPostsDto 
{
	private String id;

	@NotNull
	@Length(min = 1, max = 50)
	private String title;

	@NotNull
	@Length(min = 1, max = 50)
	private String tags;

	@NotNull
	@Length(min = 1, max = 500)
	private String postDescription;

	public VisitorPostsDto() {
		super();
	}

	public VisitorPostsDto(String id, String title, String tags, String postDescription) {
		super();
		this.id = id;
		this.title = title;
		this.tags = tags;
		this.postDescription = postDescription;
	}
	  
/*	 * public Long getPostId() { return postId; } public void setPostId(Long postId)
	 * { this.postId = postId; }
	 * 
	 * public String getTitle() { return title; } public void setTitle(String title)
	 * { this.title = title; }
	 * 
	 * public String getTags() { return tags; } public void setTags(String tags) {
	 * this.tags = tags; }
	 * 
	 * public String getPostDescription() { return postDescription; } public void
	 * setPostDescription(String postDescription) { this.postDescription =
	 * postDescription; }
	 * 
	 * @Override public String toString() { return "VisitorPostsDto [postId=" +
	 * postId + ", title=" + title + "]"; }
	 */	 
}

// Project Lombok is a small library that can be used to reduce the amount of boilerplate Java code 
// that is commonly written for Java classes.  Project Lombok does this via annotations that can be 
// added to the Java class for which common methods are desired.  Most of the annotations are 
// self-descriptive in their names: @Getter, @Setter, @EqualsAndHashCode, @ToString, and @NoArgsConstructor 
// are examples.

// It is probable that this collection of Lombok annotations would be commonly desired, especially for 
// data-oriented classes. For this reason, Project Lombok provides aggregated annotations such as @Data 
// that provide a collection of these annotations. In this case, I could have gotten very similar behavior 
// to the several individual annotations I provided by using @Data. The @Data annotation leads to Lombok 
// apply @Getter to all fields and @Setter to all non-final fields. The other major difference is that it 
// uses @RequiredArgsConstructor rather than @AllArgsConstructor.