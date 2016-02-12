package com.au.example.client.util.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.Provider;

import org.apache.commons.io.IOUtils;

@Provider
public class DtoClientResponceFilter implements ClientResponseFilter {

	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("responce");
		System.out.println("cookie");
		for (String key : responseContext.getCookies().keySet()) {
			System.out.println("key " + key + " value " + responseContext.getCookies().get(key));
		}
		System.out.println("header");
		for (String key : responseContext.getHeaders().keySet()) {
			System.out.println("key " + key + " value " + responseContext.getHeaders().get(key));
		}
		logResponse(responseContext);
	}

	private void logResponse(ClientResponseContext responseContext) throws IOException {

		String responseBody = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = responseContext.getEntityStream();
		try {

			byte[] content = IOUtils.toByteArray(in);
			out.write(content);
			responseContext.setEntityStream(new ByteArrayInputStream(out.toByteArray()));
			responseBody = new String(out.toByteArray());
			System.out.println(responseBody);
		} catch (IOException ex) {
			throw ex;
		} // end try/catch

		responseBody = (responseBody == null) ? "" : "\n" + responseBody;

		System.out.println("\nClient Response:\nStatus: " + responseContext.getStatus() + responseBody);

	}

}