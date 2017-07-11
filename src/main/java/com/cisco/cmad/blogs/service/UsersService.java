package com.cisco.cmad.blogs.service;

import java.util.List;

import com.cisco.cmad.blogs.api.BlogException;
import com.cisco.cmad.blogs.api.DataNotFoundException;
import com.cisco.cmad.blogs.api.DuplicateDataException;
import com.cisco.cmad.blogs.api.InvalidDataException;
import com.cisco.cmad.blogs.api.User;
import com.cisco.cmad.blogs.api.Users;
import com.cisco.cmad.blogs.data.UsersDAO;
import com.cisco.cmad.blogs.data.UsersDAOImpl;

public class UsersService implements Users{

	 private UsersDAO dao = new UsersDAOImpl();
	 
	@Override
	public void create(User user) throws InvalidDataException, DuplicateDataException, BlogException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User read(String userId) throws DataNotFoundException, BlogException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> readAllUsers() throws DataNotFoundException, BlogException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User user) throws InvalidDataException, DuplicateDataException, BlogException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String userId) {
		// TODO Auto-generated method stub
		
	}

}
