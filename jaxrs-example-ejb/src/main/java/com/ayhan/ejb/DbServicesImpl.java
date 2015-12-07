package com.ayhan.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ayhan.model.Location;

@Stateless
public class DbServicesImpl implements DbServices{

	@PersistenceContext(name="MyAppUnit")
	private EntityManager em;

	public long create(Location location) {
		em.persist(location);
		return location.getId();
	}
	
	public Location find(long locationId) {
		return em.find(Location.class,locationId);
	}
	

}
