package com.au.example.db.dao;


public interface BaseDao<T,PK> {
	
	T findById(PK pk);
	
	void createUser(T entity);
	

}
