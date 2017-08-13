package com.cisco.cmad.blogs.api;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.PrePersist;

@Entity
public class Blog {

	@Id
	private long blogId;

	private String title;
	private String blogContent;
	private String category;

	private int upVote;
	private int downVote;

	private Date lastUpdatedOn = new Date();
	@PrePersist void prePersist() { lastUpdatedOn = new Date(); }

	private String author;

	public Blog() {
	}

	public Blog(long id, String title, String blogContent, Date lastUpdatedOn, String author) {
		super();
		this.blogId = id;
		this.title = title;
		this.blogContent = blogContent;
		this.lastUpdatedOn = lastUpdatedOn;
		this.author = author;
	}

	public long getBlogId() {
		return blogId;
	}

	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getUpVote() {
		return upVote;
	}

	public void setUpVote(int upVote) {
		this.upVote = upVote;
	}

	public int getDownVote() {
		return downVote;
	}

	public void setDownVote(int downVote) {
		this.downVote = downVote;
	}

	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
