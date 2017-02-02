package com.au.example.services.db.dao.user;

import com.au.example.services.db.dao.BaseDao;
import com.au.example.services.db.dom.user.User;

public interface UserDao extends BaseDao<User, Long> {
	
	User findByUsername(String username); 

}
