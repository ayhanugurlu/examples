package com.au.example.basedto.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.au.example.basedto.dto.Car;

/**
 * Restfull servis inheritance example
 * 
 * 
 * @author ayhanu
 *
 */
@Path("/restBaseDto")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class RestBaseDto {

	/**
	 * Get car  servisi	
	 * 
	 * @return
	 */
	@GET
	@Path("getCar")
	public Car getCar() {
		Car car = new Car();
		car.setModel("i30");
		car.setName("hyundai");
		return car;
	}
	
	
	/**
	 * Get car  servisi	
	 * 
	 * @return
	 */
	@GET
	@Path("getCarException")
	public Car getCarException() {
		throw new RuntimeException();
	}
	

}
