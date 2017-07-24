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
	 
	 private static UsersService usersService = null;

	    private UsersService() {
	    }

	    public static UsersService getInstance() {
	        if (usersService == null) {
	            usersService = new UsersService();
	        }
	        return usersService;
	    }
	 
	@Override
	public void create(User user) throws InvalidDataException, DuplicateDataException, BlogException {
		if (user == null)
            throw new BlogException();
        dao.create(user);
	}

	@Override
	public User read(String userId) throws DataNotFoundException, BlogException {
		 User user = dao.read(userId);
	        if (user == null)
	            throw new DataNotFoundException();
	        return user;
	}

	@Override
	public List<User> readAllUsers() throws DataNotFoundException, BlogException {
		List<User> users = dao.readAllUsers();
        if (users == null)
            throw new DataNotFoundException();
        return users;
	}

	@Override
	public User update(User updatedUser) throws InvalidDataException, DuplicateDataException, BlogException {
		if (updatedUser == null)
            throw new InvalidDataException();

        try {
            dao.update(updatedUser);
        } catch (Exception e) {
            throw new BlogException();
        }
        return updatedUser;
	}

	@Override
	public void delete(String userId) throws BlogException{
		 read(userId);
	        try {
	            dao.delete(userId);
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new BlogException();
	        }
	}

}
