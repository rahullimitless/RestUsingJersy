package com.demo.rest.messanger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class CommentResource {
	
	@GET
	public String test()
	{
		return "New Sub Resources Comment Resource";
	}

}
