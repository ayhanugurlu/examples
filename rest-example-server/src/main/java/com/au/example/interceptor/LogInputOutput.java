package com.au.example.interceptor;

import java.io.IOException;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LogInputOutput {

	@AroundInvoke
	public Object log(InvocationContext ctx) throws Exception {
		Object returnObject = null;

		if (ctx.getMethod().getDeclaringClass().isAnnotationPresent(Log.class)) {
			System.out.println("---------" + ctx.getMethod().getDeclaringClass().getName() + "---------");
			Object[] objects = ctx.getParameters();
			for (Object o : objects) {
				System.out.println(objectToJson(o));
			}
		}

		returnObject = ctx.proceed();

		if (ctx.getMethod().getDeclaringClass().isAnnotationPresent(Log.class)) {
			System.out.println(objectToJson(returnObject));
		}

		return returnObject;

	}

	private String objectToJson(Object input) {

		ObjectMapper mapper = new ObjectMapper();
		// Object to JSON in String
		String jsonInString = null;
		try {
			jsonInString = mapper.writeValueAsString(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonInString;

	}

}
