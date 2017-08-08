package com.cisco.cmad.blogs.api;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "Comment")
@NamedQueries({
		@NamedQuery(name = Comment.FIND_BLOG_COMMENTS, query = "SELECT c FROM Comment c WHERE c.blog.blogId = :blogId ORDER BY c.lastUpdatedOn DESC"),
		@NamedQuery(name = Comment.COUNT_BLOG_COMMENTS, query = "SELECT COUNT(c) FROM Comment c WHERE c.blog.blogId = :blogId") })
public class Comment {

	public static final String FIND_BLOG_COMMENTS = "Blog.findBlogComments";
	public static final String COUNT_BLOG_COMMENTS = "Blog.countBlogComments";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long commentId;

	@NotNull
	private String commentText;

	@NotNull
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedOn;

	private int upVote;
	private int downVote;

	@ManyToOne
	private User addedBy;

	@ManyToOne
	private Blog blog;

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

	public User getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(User addedBy) {
		this.addedBy = addedBy;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

}
