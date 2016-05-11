package com.au.example.basic;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.au.example.basic.services.HelloEJB;

@Path("/helloServices")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class HelloServices {

	@Inject
	HelloEJB helloEJB;

	@GET
	@Path("test")
	public String test() {
		return "test";
	}

	@GET
	@Path("sayHello")
	public String sayHello(String name) {
		return helloEJB.sayHelloEJB(name);
	}

}
