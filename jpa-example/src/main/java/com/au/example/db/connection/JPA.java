package com.au.example.db.connection;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.au.example.db.common.ConnectionProperties;

public class JPA<E> {

	private EntityManager em = null;

	public JPA getInstance(ConnectionProperties connProperties) {

		if (null == em) {
			em = connProperties.getConnection();
		} else if (null != em && !em.isOpen()) {
			em.getTransaction().rollback();
			em.close();
			em = connProperties.getConnection();
		}

		return this;

	}

	public E findUnique(String sql, Map<String, Object> parameters, Class classe) {

		Query query = em.createQuery(sql, classe);

		setParameters(query, parameters);

		query.setMaxResults(1);

		List<E> list = query.getResultList();
		if (list.isEmpty())
			return null;

		return list.get(0);

	}

	public E findUniqueWithNoEntity(String sql, Map<String, Object> parameters) {

		Query query = em.createNativeQuery(sql);

		setParameters(query, parameters);

		query.setMaxResults(1);

		List<E> list = query.getResultList();
		if (list.isEmpty())
			return null;

		return list.get(0);

	}

	public List<E> findAll(String sql, Map<String, Object> parameters, Class classe) {

		Query query = em.createQuery(sql, classe);

		setParameters(query, parameters);

		List<E> list = query.getResultList();

		return list;

	}

	public List<E> findAllNative(String sql, Map<String, Object> parameters, Class classe) {

		Query query = em.createQuery(sql, classe);

		setParameters(query, parameters);

		List<E> list = query.getResultList();

		return list;

	}

	public List<E> findAllWithNoEntity(String sql, Map<String, Object> parameters) {

		Query query = em.createNativeQuery(sql);

		setParameters(query, parameters);

		List<E> list = query.getResultList();

		return list;

	}

	public List<E> findAll(Class classe) {

		CriteriaQuery<E> cq = em.getCriteriaBuilder().createQuery(classe);
		Root<E> from = cq.from(classe);
		cq.select(from);
		return em.createQuery(cq).getResultList();

	}

	public E findById(Integer id, Class classe) {
		return (E) em.find(classe, id);
	}

	public E findByReference(Integer id, Class classe) {
		return (E) em.getReference(classe, id);
	}

	public void beginTransaction() {

		while (em.getTransaction().isActive()) {
			System.out.println("Transaction in use");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		em.getTransaction().begin();
	}

	public void commitTransaction() {
		try {
			em.getTransaction().commit();
			em.clear();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				try {
					em.getTransaction().rollback();
				} catch (Exception e2) {
				}
			}
		}
	}

	public void rollback() {

		if (em.getTransaction().isActive()) {
			try {

				em.getTransaction().rollback();

			} catch (Exception e) {

				System.out.println("Erro ao realizar o rollback na transação");
			}

		}

	}

	public void commitAndReopenTransaction() {
		commitTransaction();
		beginTransaction();
	}

	public E merge(E model) {

		E actualModel = em.merge(model);
		return actualModel;

	}

	public void save(E model) {

		em.persist(model);

	}

	public Boolean update(String query) {

		if (em.createNativeQuery(query).executeUpdate() > 0) {
			return true;
		}
		return false;

	}

	public Boolean update(String query, Map parameters) {

		Query myQuery = em.createNativeQuery(query);
		setParameters(myQuery, parameters);

		if (myQuery.executeUpdate() > 0) {
			return true;
		}
		return false;

	}

	public Boolean update(E model) {

		em.persist(model);
		return true;

	}

	public List<E> callProcedure(String sql, Map<String, Object> parameters, Class classe) {

		Query query = em.createNativeQuery(sql, classe);

		setParameters(query, parameters);
		List resultList = query.getResultList();

		return resultList;

	}

	public List<E> callProcedureWithNoEntity(String sql, Map<String, Object> parameters) {

		Query query = em.createNativeQuery(sql);

		setParameters(query, parameters);
		List resultList = query.getResultList();

		return resultList;

	}

	public void setParameters(Query query, Map<String, Object> parameters) {
		if (null != parameters) {
			for (String key : parameters.keySet()) {
				query.setParameter(key, parameters.get(key));
			}
		}
	}

	public void refresh(E entity) {
		em.refresh(entity);
	}

}