package com.ayhan.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.ayhan.ejb.DbServices;
import com.ayhan.model.Location;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPoint;

@Path("/restexample")
@Stateless
public class RestService {

	@EJB
	DbServices dbServices;

	@GET
	@Path("{id}")
	public Response getUserById(@PathParam("id") String id) {
		Coordinate[] coordinates = new Coordinate[1];
		coordinates[0] = new Coordinate(1, 2);
		
		MultiPoint m = new GeometryFactory().createMultiPoint(coordinates);
		

		Location location = new Location();

		
		location.setName("test");
		location.setLocation(m);

		dbServices.create(location);

		return Response.status(200).entity("getUserById is called, id : " + id).build();

	}

	@GET
	@Path("{year}/{month}/{day}")
	public Response getUserHistory(@PathParam("year") int year, @PathParam("month") int month,
			@PathParam("day") int day) {

		String date = year + "/" + month + "/" + day;

		return Response.status(200).entity("getUserHistory is called, year/month/day : " + date).build();

	}

}