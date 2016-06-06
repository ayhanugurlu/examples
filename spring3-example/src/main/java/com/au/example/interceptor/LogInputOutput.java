package com.au.example.interceptor;

import java.io.IOException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
public class LogInputOutput {

	@Around("execution(* *(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Object returnObject = null;
		Class<?> clazz = Class.forName(joinPoint.getSignature().getDeclaringTypeName());
		if (clazz.isAnnotationPresent(Log.class)) {
			System.out.println("--------------" + clazz.getName() + "-----------------");
			System.out.println("method name:" + joinPoint.getSignature().getName());
			for (Object o : joinPoint.getArgs()) {
				System.out.println(objectToJson(o));
			}
		}
		returnObject = joinPoint.proceed(); 
		if (clazz.isAnnotationPresent(Log.class)) {
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