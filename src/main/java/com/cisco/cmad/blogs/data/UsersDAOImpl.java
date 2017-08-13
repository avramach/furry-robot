package com.cisco.cmad.blogs.data;

import java.util.List;
import java.util.logging.Logger;

import com.cisco.cmad.blogs.api.User;
import com.cisco.cmad.blogs.util.Constants;
import com.cisco.cmad.jwt.utils.PasswordUtils;

public class UsersDAOImpl implements UsersDAO {

	@Override
	public void create(User user) {
	}

	@Override
	public User read(String userName) {
		User user = null;
		return user;
	}

	@Override
	public User readByUserIdAndPassword(String userName, String password) {
		User user = null;
		return user;
	}

	@Override
	public List<User> readAllUsers() {
		List<User> users = null;
		return users;
	}

	@Override
	public void update(User updatedUser) {
	}

	@Override
	public void delete(String userId) {
	}
}
