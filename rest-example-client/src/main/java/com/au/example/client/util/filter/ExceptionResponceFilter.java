package com.au.example.client.util.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;

import com.au.example.exception.util.ServerError;

public class ExceptionResponceFilter implements ClientResponseFilter {

	private static final String EXCEPTIONCLASSES = "ExceptionClasses";

	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {

		if (responseContext.getHeaders().containsKey(EXCEPTIONCLASSES)) {
			createClientException(responseContext);
		}

	}

	private void createClientException(ClientResponseContext responseContext) throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = responseContext.getEntityStream();
		try {

			byte[] content = IOUtils.toByteArray(in);
			out.write(content);
			responseContext.setEntityStream(new ByteArrayInputStream(out.toByteArray()));
			WebApplicationException webApplicationException = mapper.readValue(out.toByteArray(), WebApplicationException.class);
			ServerError serverError = new ServerError(webApplicationException);
			WebApplicationException rootException = serverError.getRootException();
			if (rootException != null) {
				throw rootException;
			}
		} catch (IOException ex) {
			throw ex;
		} // end try/catch
	}

}
