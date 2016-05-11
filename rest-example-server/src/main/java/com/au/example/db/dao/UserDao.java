package com.au.example.db.dao;

import java.util.List;

import javax.ejb.Local;

import com.au.example.db.model.User;

@Local
public interface UserDao {

	void create(User user);

	void update(User user);

	User findById(Long id);
	
	List<User> getAll();
}
