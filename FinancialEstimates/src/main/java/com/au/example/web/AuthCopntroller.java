package com.au.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.au.example.services.AuthenticationService;

@Controller
@RequestMapping("/auth")
public class AuthCopntroller {

	@Autowired
	AuthenticationService authenticationService;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String passwod) {
		return "OK";
	}

}
