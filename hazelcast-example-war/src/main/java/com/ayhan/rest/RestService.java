package com.ayhan.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ayhan.hazelcast.HazelClient;

@Path("/resthazelcast")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class RestService {
	
	@GET
	@Path("addHazelcast")
	public boolean addHazelcast(@QueryParam("key")String key,@QueryParam("value")String value){
		boolean result = false;		
		HazelClient.getHazelClient().addValue(key, value);
		result = true;		
		return result;		
	}
	
	
	@GET
	@Path("getHazelcast")
	public String getHazelcast(@QueryParam("key")String key){
		String value = HazelClient.getHazelClient().getValue(key);;		
		return value;		
	}
	
}
