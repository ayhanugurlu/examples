package com.au.example.db.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.au.example.db.model.User;

@Stateless
public class UserDaoImpl implements UserDao {

	@PersistenceContext(name = "MyAppUnit")
	private EntityManager em;

	@Override
	public void create(User user) {
		em.persist(user);
	}
	
	
	@Override
	public void update(User user) {
		em.merge(user);
	}


	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return em.find(User.class,id);
	}

}
