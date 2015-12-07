package com.ayhan.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.ayhan.ejb.DbServices;
import com.ayhan.model.Location;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

@Path("/restexample")
@Stateless
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

}