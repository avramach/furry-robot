package com.cisco.cmad.blogs.service;

import java.util.List;

import com.cisco.cmad.blogs.api.Blog;
import com.cisco.cmad.blogs.api.BlogException;
import com.cisco.cmad.blogs.api.Blogs;
import com.cisco.cmad.blogs.api.DataNotFoundException;
import com.cisco.cmad.blogs.api.DuplicateDataException;
import com.cisco.cmad.blogs.api.InvalidDataException;
import com.cisco.cmad.blogs.data.BlogsDAO;
import com.cisco.cmad.blogs.data.BlogsDAOImpl;

public class BlogsService implements Blogs{

	 private BlogsDAO dao = new BlogsDAOImpl();
	 
	@Override
	public void create(Blog blog) throws InvalidDataException, DuplicateDataException, BlogException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Blog update(Blog updatedBlog) throws InvalidDataException, BlogException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long blogId) throws DataNotFoundException, BlogException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Blog> readByCategory(String category) throws DataNotFoundException, BlogException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> readAllBlogs() throws DataNotFoundException, BlogException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blog read(long blogId) throws DataNotFoundException, BlogException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> readByUserId(String userId, int pageNum) throws DataNotFoundException, BlogException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getUpVote(long blogId) throws DataNotFoundException, BlogException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getDownVote(long blogId) throws DataNotFoundException, BlogException {
		// TODO Auto-generated method stub
		return 0;
	}

}
