package com.cisco.cmad.blogs.rest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.cisco.cmad.blogs.api.Blog;
import com.cisco.cmad.blogs.data.BlogsDAO;
import com.cisco.cmad.blogs.service.BlogsService;

@RunWith(MockitoJUnitRunner.class)
public class BlogsServiceTest {

	@InjectMocks
	private BlogsService blogsService;

	@Mock
	private BlogsDAO dao;

	@Test
	public void testCreate() {
		try {
			Mockito.doNothing().when(dao).create(Mockito.mock(Blog.class));
			blogsService.create(Mockito.mock(Blog.class));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void testUpdate() {
		try {
			Mockito.doNothing().when(dao).update(Mockito.mock(Blog.class));
			blogsService.update((Mockito.mock(Blog.class)));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void testDelete() {
		try {
			Mockito.doNothing().when(dao).delete(Mockito.anyInt());
			Mockito.when(dao.read(Mockito.anyInt())).thenReturn(new Blog());
			blogsService.delete(Mockito.anyInt());
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void testReadByCategory() {
		try {
			List<Blog> blogs = new ArrayList<Blog>();
			blogs.add(new Blog());
			Mockito.when(dao.readByCategory(Mockito.anyString())).thenReturn(blogs);
			List<Blog> actualBlogs = blogsService.readByCategory(Mockito.anyString());
			Assert.assertEquals(blogs, actualBlogs);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

}
