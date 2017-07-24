package com.cisco.cmad.blogs.data;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cisco.cmad.blogs.api.User;
import com.cisco.cmad.blogs.util.Constants;

public class UsersDAOImpl implements UsersDAO {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
	private Logger logger = Logger.getLogger(getClass().getName());

	@Override
	public void create(User user) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		user.setPassword(user.getPassword());
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public User read(String userId) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, userId);
		em.getTransaction().commit();
		em.close();
		return user;
	}

	@Override
	public User readByUserIdAndPassword(String userId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> readAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String userId) {
		// TODO Auto-generated method stub

	}

}
