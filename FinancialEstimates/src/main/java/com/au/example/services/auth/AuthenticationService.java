package com.au.example.services.auth;

import com.au.example.services.db.dom.user.User;



public interface AuthenticationService {
	
	void createUser(User user);
	
	User findUser(String username);	
	
}
