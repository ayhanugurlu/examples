package com.au.example.services.db.dao.user;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.au.example.services.db.dao.AbstractDao;
import com.au.example.services.db.dom.user.User;



@Repository
public class UserDaoImpl extends AbstractDao<User, Long> implements UserDao{

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		Query query =  entityManager.createQuery("select u from User u where u.username = :username");
		query.setParameter("username",username);
		User user =  (User) query.getSingleResult();		
		return user;
	}
	
}
