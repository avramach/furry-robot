package com.cisco.cmad.blogs.rest;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cisco.cmad.blogs.api.Blog;
import com.cisco.cmad.blogs.api.Blogs;
import com.cisco.cmad.blogs.api.Comments;
import com.cisco.cmad.blogs.service.BlogsService;
import com.cisco.cmad.blogs.service.CommentsService;

@Path("/blogs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BlogsController {
	private Blogs blogsService = BlogsService.getInstance();
    /*private Comments commentsService = CommentsService.getInstance();
    private Logger logger = Logger.getLogger(getClass().getName());*/
    
    @POST
    @Path("/")
    public Response create(Blog blog) {
        blogsService.create(blog);
        return Response.ok().entity(blog).build();
    }
    
    @GET
    @Path("/{blogId}")
    public Response read(@PathParam("blogId") long blogId) {
        Blog blog = blogsService.read(blogId);
        return Response.ok().entity(blog).build();
    }
}
