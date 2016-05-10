package com.au.example.db.dao;

import javax.ejb.Local;

import com.au.example.db.model.User;

@Local
public interface UserDao {

	void create(User user);

	void update(User user);

	User findById(Long id);
}
