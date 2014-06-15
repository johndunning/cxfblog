package com.skills421.services;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Service;

import com.skills421.model.Customer;

@Service
@Path("/customer")
public class CustomerService
{
	private Map<Integer,Customer> customers = new HashMap<Integer, Customer>();
	
	@PUT
    @Path("/add/{id}")
    @Consumes("application/json")
    public Response addCustomer(@PathParam("id") int id,Customer customer) 
	{
		customers.put(id,customer);
		return Response.status(Status.OK).build();
	}
	
	@GET
	@Path("/find/{id}")
	@Produces("application/json")
	public Response find(@PathParam("id") int id)
	{
		Customer customer = customers.get(id);
		
		return Response.status(Status.OK).entity(customer).type(MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/default")
	@Produces("application/json")
	public Response getDefault()
	{
		Customer customer = new Customer(1,"Jon Doe",21);
		
		return Response.status(Status.OK).entity(customer).type(MediaType.APPLICATION_JSON).build();
	}
}
