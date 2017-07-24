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
	
	private static CommentsService commentsService = null;

    private CommentsService() {
    }

    public static CommentsService getInstance() {
        if (commentsService == null) {
            commentsService = new CommentsService();
        }
        return commentsService;
    }
	
	@Override
	public void create(Comment comment) throws InvalidDataException, DuplicateDataException, BlogException {
		if (comment == null)
            throw new InvalidDataException();
        dao.create(comment);
	}

	@Override
	public Comment read(long commentId) throws DataNotFoundException, BlogException {
		Comment comment = dao.read(commentId);
        if (comment == null)
            throw new DataNotFoundException();
        return comment;
	}

	@Override
	public List<Comment> readAllByBlogId(long blogId) throws DataNotFoundException, BlogException {
		List<Comment> comments = dao.readAllByBlogId(blogId);
        if (comments == null)
            throw new DataNotFoundException();
        return comments;
	}

	@Override
	public Comment update(Comment updatedComment) throws DataNotFoundException, BlogException {
		if (updatedComment == null)
            throw new BlogException();

        try {
            dao.update(updatedComment);
        } catch (Exception e) {
            throw new DataNotFoundException();
        }
        return updatedComment;
	}

	@Override
	public void delete(long id) throws BlogException {
		read(id);
        try {
            dao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BlogException();
        }
	}

	@Override
	public long readCountByBlogId(long blogId) throws DataNotFoundException, BlogException {
		long count = dao.readCountByBlogId(blogId);
        return count;
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
