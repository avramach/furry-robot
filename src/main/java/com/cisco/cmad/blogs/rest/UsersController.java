package com.cisco.cmad.blogs.rest;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cisco.cmad.blogs.api.BlogException;
import com.cisco.cmad.blogs.api.DataNotFoundException;
import com.cisco.cmad.blogs.api.DuplicateDataException;
import com.cisco.cmad.blogs.api.InvalidDataException;
import com.cisco.cmad.blogs.api.User;
import com.cisco.cmad.blogs.api.Users;
import com.cisco.cmad.blogs.service.UsersService;

@Path("/users")
public class UsersController {

	private static Users users = UsersService.getInstance();
	private Logger logger = Logger.getLogger(getClass().getName());

	@GET
	@Path("/{userId}")
	public Response read(@PathParam("userId") String userId) {
		User user = users.read(userId);
		return Response.ok().entity(user).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		try {
			// TODO implementation
			return Response.ok().build();
		} catch (DataNotFoundException dnfe) {
			return Response.status(Response.Status.NO_CONTENT).build();
		} catch (BlogException be) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(User user) {
		try {
			users.create(user);
			return Response.status(Response.Status.CREATED).build();
		} catch (InvalidDataException ide) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} catch (DuplicateDataException dde) {
			return Response.status(Response.Status.CONFLICT).build();
		} catch (BlogException be) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("username") String username) {
		try {
			// TODO implementation
			return Response.ok().build();
		} catch (DataNotFoundException dnfe) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} catch (BlogException be) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	// INFO should have been PATCH - but JERSY does not support PATCH and hence
	// using POST
	@POST
	@Path("/{username}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("username") String username) {
		try {
			// TODO implementation
			return Response.ok().build();
		} catch (DataNotFoundException dnfe) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} catch (BlogException be) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DELETE
	@Path("/{username}")
	public Response delete(@PathParam("username") String username) {
		try {
			// TODO implementation
			return Response.ok().build();
		} catch (DataNotFoundException dnfe) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} catch (BlogException be) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GET
	@Path("/{username}/blogs")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBlogs(@PathParam("username") String username) {
		try {
			// TODO implementation
			return Response.ok().build();
		} catch (DataNotFoundException dnfe) {
			return Response.status(Response.Status.NO_CONTENT).build();
		} catch (BlogException be) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GET
	@Path("/{username}/comments")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getComments(@PathParam("username") String username) {
		try {
			// TODO implementation
			return Response.ok().build();
		} catch (DataNotFoundException dnfe) {
			return Response.status(Response.Status.NO_CONTENT).build();
		} catch (BlogException be) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
