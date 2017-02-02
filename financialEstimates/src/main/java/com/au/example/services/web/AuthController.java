package com.au.example.services.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.au.example.services.auth.AuthenticationService;
import com.au.example.services.db.dom.user.User;


@RestController
public class AuthController {

	@Autowired
	AuthenticationService authenticationService;

	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String test() {
		return "TEST";
	}
	
	@RequestMapping(path = "/login/{username}", method = RequestMethod.GET)
	public String login(@PathVariable String username) {
		return username;		
	}
	@RequestMapping(path = "/users/{username}", method = RequestMethod.GET)
	public User users(@PathVariable String username) {
		System.out.println("ayhana");
		return null;
	}
	
	
	@RequestMapping(path = "/users/login/{username}/{password}", method = RequestMethod.GET)
	public String login(@PathVariable String username,@PathVariable String password) {
		System.out.println("ayhana");
		return "succes";
	}
	

}
