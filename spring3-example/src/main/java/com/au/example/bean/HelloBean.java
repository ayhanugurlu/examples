package com.au.example.bean;

import com.au.example.interceptor.Log;

@Log
public class HelloBean {
	
	private String name;
	
	public String sayHello() {
		return "Hello " + name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
