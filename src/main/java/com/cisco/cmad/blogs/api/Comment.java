package com.cisco.cmad.blogs.api;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.PrePersist;

@Entity
public class Comment {

	@Id
	private long commentId;

	private String commentText;

	private Date lastUpdatedOn = new Date();
	@PrePersist void prePersist() { lastUpdatedOn = new Date(); }

	private int upVote;
	private int downVote;

	private String author;
	private long blogId;

	public long getBlogId() {
		return blogId;
	}

	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}

	public Comment() {
		super();
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
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

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
