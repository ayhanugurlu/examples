package com.au.example.client.util.filter;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class DtoClientRequestFilter implements ClientRequestFilter{

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("request");
		
		
	}


}
