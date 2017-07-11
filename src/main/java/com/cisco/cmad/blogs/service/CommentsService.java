package com.cisco.cmad.blogs.service;

import java.util.List;

import com.cisco.cmad.blogs.api.BlogException;
import com.cisco.cmad.blogs.api.Comment;
import com.cisco.cmad.blogs.api.Comments;
import com.cisco.cmad.blogs.api.DataNotFoundException;
import com.cisco.cmad.blogs.api.DuplicateDataException;
import com.cisco.cmad.blogs.api.InvalidDataException;
import com.cisco.cmad.blogs.data.CommentsDAO;
import com.cisco.cmad.blogs.data.CommentsDAOImpl;

public class CommentsService implements Comments{

	private CommentsDAO dao = new CommentsDAOImpl();
	
	@Override
	public void create(Comment comment) throws InvalidDataException, DuplicateDataException, BlogException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Comment read(long commentId) throws DataNotFoundException, BlogException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> readAllByBlogId(long blogId) throws DataNotFoundException, BlogException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment update(Comment comment) throws DataNotFoundException, BlogException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) throws BlogException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long readCountByBlogId(long blogId) throws DataNotFoundException, BlogException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getUpVote(long commentId) throws DataNotFoundException, BlogException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getDownVote(long commentId) throws DataNotFoundException, BlogException {
		// TODO Auto-generated method stub
		return 0;
	}

}
