package com.offcn.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.offcn.pojo.User;

@Service

public interface HelloWorldService {

	 @GET
	 @Path("/search/{phone}")
	 @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public User search(@PathParam("phone")String number);

}
