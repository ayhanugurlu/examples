package com.au.example.basic.services;

public class HelloEJBImpl implements HelloEJB {
	public String sayHelloEJB(String name) {
		return "Hello " + name;
	}
}
