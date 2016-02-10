package com.au.example.client.util.filter;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;

public class ExceptionResponceFilter implements ClientResponseFilter {

	private static final String ERRORMESSAGE = "ErrorMessage";

	private static final String EXCEPTIONCLASSES = "ExceptionClasses";

	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
		// TODO Auto-generated method stub
		RuntimeException rootException = null; 
		if (responseContext.getHeaders().containsKey(EXCEPTIONCLASSES)) {
			try {

				try {
					rootException = getRootException(responseContext.getHeaders().get(EXCEPTIONCLASSES).toString().split("\\|")[0].toString(), responseContext.getHeaders().get(ERRORMESSAGE)
							.toString().split("\\|"));
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(rootException != null){
				throw rootException;
			}

		}
		for (String key : responseContext.getHeaders().keySet()) {
			System.out.println("key " + key + " value " + responseContext.getHeaders().get(key));
		}

	}

	public RuntimeException getRootException(String rootExceptionClassName, String[] errorMessages) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException {
		RuntimeException rootException = null;

		Class<? extends RuntimeException> clazz = (Class<? extends RuntimeException>) Class.forName(rootExceptionClassName.substring(1));
		if (RuntimeException.class.isAssignableFrom(clazz)) {
			Constructor<?> constructor = null;
			try {
				constructor = clazz.getConstructor(String.class);
				String messages = "";

				for (int i = 0; i < errorMessages.length; i++) {
					if (i != (errorMessages.length - 1)) {
						messages += errorMessages[i] + ", ";
					} else {
						messages += errorMessages[i];
					}
				}
				rootException = (RuntimeException) constructor.newInstance(messages);
			} catch (NoSuchMethodException e) {
				// ignore this exception, we will raise another if
				// we cannot find the default constructor
			}
			if (constructor == null) {
				constructor = clazz.getConstructor();
				rootException = (RuntimeException) constructor.newInstance();
			}

		}

		return rootException;
	}

}
