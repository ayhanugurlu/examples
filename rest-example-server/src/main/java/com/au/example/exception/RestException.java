package com.au.example.exception;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.au.example.exception.util.ServerException;

/**
 * Restfull servis inheritance example
 * 
 * 
 * @author ayhanu
 *
 */
@Path("/restException")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class RestException {

	/**
	 * Test servisi	
	 * 
	 * @return
	 */
	@GET
	@Path("test")
	public String test() {
		return "test";
	}
	
	
	/**
	 * Test servisi	
	 * 
	 * @return
	 */
	@GET
	@Path("testExp")
	public String testExp() throws ServerException{
		throw new ServerException();		
	}

}
