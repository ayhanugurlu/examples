package com.ayhan.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ayhan.model.Location;

@Stateless
public class DbServicesImpl implements DbServices{

	@PersistenceContext(name="MyAppUnit")
	private EntityManager em;

	public void create(Location location) {
		em.persist(location);
	}
	
	public Location find(Location location) {
		return em.find(Location.class,1);
	}
	

}
