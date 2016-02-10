/**
 * Created by Apache CXF WadlToJava code generator
**/
package com.au.example.exception;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/restException")
public interface RestException {

    @GET
    @Produces("application/json")
    @Path("/test")
    String test();

    @GET
    @Produces("application/json")
    @Path("/testExp")
    String testExp();

}