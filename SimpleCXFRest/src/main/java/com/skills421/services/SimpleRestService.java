package com.skills421.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;

@Service
@Path("/greet")
public class SimpleRestService
{
	@GET
	@Path("/{name}")
	@Produces("text/plain")
	public String sayHello(@PathParam("name") String name)
	{
		return "Hello "+name;
	}
}
