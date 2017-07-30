package com.cisco.cmad.blogs.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cisco.cmad.blogs.api.Blog;
import com.cisco.cmad.blogs.util.Constants;

public class BlogsDAOImpl implements BlogsDAO {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);

	 private UsersDAO userDao = new UsersDAOImpl();
	 
	@Override
	public void create(Blog blog) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			
			//temporary fix
			//TODO get the existng user and associate it;
			blog.setAuthor(userDao.read(blog.getAuthor().getUserId()));
			
			em.persist(blog);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Blog read(long blogId) {
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Blog blog = em.find(Blog.class, blogId);
		em.getTransaction().commit();

		em.close();
		return blog;
	}

	@Override
	public List<Blog> readByCategory(String category) {
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
	    TypedQuery<Blog> query = em.createQuery("SELECT b FROM Blog b WHERE b.category = :category", Blog.class);
	    query.setParameter("category", category);
	    List<Blog> blogs = query.getResultList();
	    em.getTransaction().commit();

	    em.close();
	    return blogs;
	}

	@Override
	public List<Blog> readAllBlogs() {
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
	    TypedQuery<Blog> query = em.createQuery("SELECT b FROM Blog b", Blog.class);
	    List<Blog> blogs = query.getResultList();
	    em.getTransaction().commit();

	    em.close();
	    return blogs;
	}

	@Override
	public List<Blog> readByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Blog blog) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
