package com.au.example.services.db.dao.user;

import org.springframework.stereotype.Repository;

import com.au.example.services.db.dao.AbstractDao;
import com.au.example.services.db.dom.user.User;



@Repository
public class UserDaoImpl extends AbstractDao<User, Long> implements UserDao{
	

}
