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

@Entity(name = "Blog")
@NamedQueries({
		@NamedQuery(name = Blog.DELETE_BLOG_COMMENTS, query = "DELETE FROM Comment c WHERE c.blog.blogId = :blogId"),
		@NamedQuery(name = Blog.FIND_USER_BLOGS, query = "SELECT b FROM Blog b WHERE b.author.userName = :userName") })

public class Blog {

	public static final String DELETE_BLOG_COMMENTS = "Blog.deleteBlogComments";
	public static final String FIND_USER_BLOGS = "Blog.findUserBlogs";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long blogId;

	@NotNull
	private String title;

	@NotNull
	private String blogContent;

	private String category;
	private int upVote;
	private int downVote;

	// @NotNull
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedOn;

	@ManyToOne
	private User author;

	public Blog() {
	}

	public Blog(long id, String title, String blogContent, Date lastUpdatedOn, User author) {
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

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

}
