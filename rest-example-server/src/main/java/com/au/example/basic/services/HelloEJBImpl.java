package com.au.example.basic.services;

import javax.ejb.Stateless;

import com.au.example.interceptor.Log;

@Log
@Stateless
public class HelloEJBImpl implements HelloEJB {
	public String sayHelloEJB(String name) {
		return "Hello " + name;
	}
}
