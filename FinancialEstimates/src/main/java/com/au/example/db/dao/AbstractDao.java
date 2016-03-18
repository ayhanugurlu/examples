package com.au.example.db.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public abstract class AbstractDao<T, PK> implements BaseDao<T, PK> {

	private final Class<T> entityClass;

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T findById(PK pk) {

		EntityManager em = entityManagerFactory.createEntityManager();
		return em.find(entityClass, pk);

	}

	public void createUser(T entity) {

		EntityManager em = entityManagerFactory.createEntityManager();
		em.persist(entity);

	}

}
