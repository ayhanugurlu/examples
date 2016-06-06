package com.au.example.interceptor;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.au.example.basic.services.HelloEJB;

@Path("/logResource")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class LogResource {


	@Inject
	HelloEJB helloEJB;
	
	
	@GET
	@Path("test")
	public String test() {
		
		helloEJB.sayHelloEJB("ayhan");
		
		return "test";
	}



}
