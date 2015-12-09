package com.ayhan.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ayhan.services.dom.Bird;
import com.ayhan.services.dom.Parrot;

@Path("/restexample")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class RestExample {

	@GET
	@Path("getParrot")
	public Parrot getParrot() {

		Parrot p = new Parrot();
		p.setColor("green");
		p.setFlying(true);
		p.setHabitat("home");
		p.setKnowledge("test");
		p.setName("hasan");
		p.setTopSpeed(5d);
		p.setVocabulary("turk");
		return p;

	}
	
	

	@GET
	@Path("getBird")
	public Bird getBird() {

		Bird bird = new Bird();
		bird.setColor("green");
		bird.setFlying(true);
		bird.setHabitat("home");
		bird.setKnowledge("test");
		bird.setName("hasan");
		bird.setTopSpeed(5d);		
		return bird;

	}

}
