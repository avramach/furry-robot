package com.cisco.cmad.blogs.rest;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.cisco.cmad.blogs.api.BlogException;
import com.cisco.cmad.blogs.api.DataNotFoundException;
import com.cisco.cmad.blogs.api.DuplicateDataException;
import com.cisco.cmad.blogs.api.InvalidDataException;
import com.cisco.cmad.blogs.api.User;
import com.cisco.cmad.blogs.api.Users;
import com.cisco.cmad.blogs.service.UsersService;
import com.cisco.cmad.blogs.util.Constants;
import com.cisco.cmad.jwt.utils.KeyGenerator;
import com.cisco.cmad.jwt.utils.SecretKeyGenerator;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Path("/users")
public class UsersController {

	private static Users userService = UsersService.getInstance();
	private Logger logger = Logger.getLogger(getClass().getName());
	private KeyGenerator keyGenerator = new SecretKeyGenerator();

	@Context
	private UriInfo uriInfo;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		try {
			List<User> matched;
			GenericEntity<List<User>> entities;
			matched = userService.readAllUsers();
			entities = new GenericEntity<List<User>>(matched) {
			};
			return Response.ok().entity(entities).build();
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
			userService.create(user);
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
			User data = userService.read(username);
			return Response.ok().entity(data).build();
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
	public Response update(@PathParam("username") String userName, User user) {
		try {
			userService.update(user);
			return Response.ok().build();
		} catch (DataNotFoundException dnfe) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} catch (BlogException be) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DELETE
	@Path("/{username}")
	public Response delete(@PathParam("username") String userName) {
		try {
			userService.delete(userName);
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

	@POST
	@Path("/{userId}") // used for authenticating user
	public Response authenticateUser(User user) {
		try {
			logger.info("#### login/password : " + user.getUserName() + "/" + user.getPassword());
			// Authenticate the user using the credentials provided
			userService.authenticate(user.getUserName(), user.getPassword());

			// Issue a token for the user
			String token = issueToken(user.getUserName());

			// Return the token on the response
			return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();

		} catch (Exception e) {
			return Response.status(UNAUTHORIZED).build();
		}
	}

	private String issueToken(String userId) {
		Key key = keyGenerator.generateKey();
		String jwtToken = Jwts.builder().setSubject(userId).setIssuer(uriInfo.getAbsolutePath().toString())
				.setIssuedAt(new Date()).setExpiration(toDate(LocalDateTime.now().plusMinutes(Constants.JWT_TIMEOUT)))
				.signWith(SignatureAlgorithm.HS512, key).compact();
		logger.info("#### generating token for a key : " + jwtToken + " - " + key);
		return jwtToken;
	}

	private Date toDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
}
