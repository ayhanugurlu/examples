package com.au.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.example.db.dao.user.UserDao;
import com.au.example.db.model.user.User;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	UserDao userDao;
	
	public void createUser(User user){
		userDao.create(user);
	}

}
