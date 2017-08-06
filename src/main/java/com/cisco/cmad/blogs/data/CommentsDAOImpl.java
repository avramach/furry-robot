package com.cisco.cmad.blogs.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cisco.cmad.blogs.api.Comment;
import com.cisco.cmad.blogs.util.Constants;

public class CommentsDAOImpl implements CommentsDAO {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);

	@Override
	public void create(Comment comment) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(comment);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Comment read(long commentId) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Comment comment = em.find(Comment.class, commentId);
		em.getTransaction().commit();
		em.close();
		return comment;
	}

	@Override
	public List<Comment> readAllByBlogId(long blogId) {
		EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Comment> tquery = em.createNamedQuery(Comment.FIND_BLOG_COMMENTS, Comment.class);
        List<Comment> comments = tquery.setParameter("blogId", blogId).getResultList();
        em.getTransaction().commit();
        em.close();
        return comments;
	}

	@Override
	public void update(Comment updatedComment) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Comment comment = em.find(Comment.class, updatedComment.getCommentId());
		comment.setCommentText(updatedComment.getCommentText());
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(long commentId) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Comment comment = em.find(Comment.class, commentId);
		em.remove(comment);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public long readCountByBlogId(long blogId) {
		EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNamedQuery(Comment.COUNT_BLOG_COMMENTS);
        query.setParameter("blogId", blogId);
        Long count = (Long) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return count;
	}

}
