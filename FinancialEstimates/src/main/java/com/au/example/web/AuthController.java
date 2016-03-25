package com.au.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.au.example.services.AuthenticationService;


@RestController
public class AuthController {

	@Autowired
	AuthenticationService authenticationService;

	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String test() {
		return "TEST";
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String passwod) {
		return "OK";
	}
	
	

}
