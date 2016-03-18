package com.ayhan.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ayhan.ejb.DbServices;
import com.ayhan.model.Location;
import com.ayhan.model.Person;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

@Path("/restexample")
@Stateless
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class RestService {

	@EJB
	DbServices dbServices;

	@GET
	@Path("createLocation")
	public Response createLocation() {
		Coordinate coordinate = new Coordinate(1, 2);
		Point point = new GeometryFactory().createPoint(coordinate);
		Location location = new Location();
		location.setLocation(point);
		location.setName("test");

		long locationId = dbServices.create(location);

		return Response.status(200)
				.entity("getUserById is called, id : " + locationId).build();

	}

	@GET
	@Path("getLocation")
	public Response getLocation(@QueryParam("id") long id) {
		Location location =  dbServices.find(id);
		return Response.status(200)
				.entity("getUserHistory is called, year/month/day : " + location.getName())
				.build();

	}
	
	@GET
	@Path("createPerson")
	public long createPerson(@QueryParam("name") String name,@QueryParam("surname") String surname) {
		long l = dbServices.createPerson(name, surname);		
		return l;
	}
	
	@GET
	@Path("getPerson")
	public Person getPerson(@QueryParam("id")long id) {				
		return dbServices.getPerson(id);
	}
	
	@GET
	@Path("updatePerson")
	public String updatePerson(@QueryParam("id")long id,@QueryParam("name") String name,@QueryParam("surname") String surname) {
		String result  = "";
		dbServices.updatePerson(id, name, surname);
		return result;
	}
	
	@GET
	@Path("deletePerson")
	public String deletePerson(@QueryParam("id")long id) {
		String result  = "";
		dbServices.deletePerson(id);
		result = "ok";
		return result;
	}
	
	
	@GET
	@Path("createData")
	public String createData(@QueryParam("value")String value,@QueryParam("type") String type) {
		
		Integer id = dbServices.createData(value, type);
		
		return id.toString();
	}

}