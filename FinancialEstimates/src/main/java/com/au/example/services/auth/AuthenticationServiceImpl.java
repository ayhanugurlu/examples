package com.au.example.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.example.services.db.dao.user.UserDao;
import com.au.example.services.db.dom.user.User;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	UserDao userDao;
	
	public void createUser(User user){
		userDao.create(user);
	}

	@Override
	public User findUser(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}

}
