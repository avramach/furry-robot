package com.cisco.cmad.blogs.api;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity(name = "User")
@NamedQueries({
		@NamedQuery(name = User.FIND_BY_LOGIN_PASSWORD, query = "SELECT u FROM User u WHERE u.userName = :userName AND u.password = :password"),
		@NamedQuery(name = User.FIND_ALL, query = "SELECT u FROM User u ORDER BY u.firstName DESC"),
		@NamedQuery(name = User.DELETE_BLOGS_BY_USER_ID, query = "DELETE FROM Blog b WHERE b.author.userName = :userName"),
		@NamedQuery(name = User.DELETE_COMMENTS_BY_USER_ID, query = "DELETE FROM Comment c WHERE c.addedBy.userName = :userName") })
public class User {

	public static final String FIND_BY_LOGIN_PASSWORD = "User.findByLoginAndPassword";
	public static final String FIND_ALL = "User.findAll";
	public static final String DELETE_BLOGS_BY_USER_ID = "User.deleteBlogsByUserId";
	public static final String DELETE_COMMENTS_BY_USER_ID = "User.deleteCommentsByUserId";

	@Id
	private String userName;

	@NotNull
	private String password;

	@NotNull
	private String firstName;

	private String lastName;

	@NotNull
	private String emailId;

	public User() {
		super();
	}

	public User(String userName, String password, String firstName, String lastName, String emailId) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
