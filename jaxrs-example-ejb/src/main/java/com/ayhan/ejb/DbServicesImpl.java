package com.ayhan.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ayhan.model.Data;
import com.ayhan.model.Location;
import com.ayhan.model.Person;

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

	public long createPerson(String name, String surname) {
		
		Person p = new Person();
		p.setName(name);
		p.setSurname(surname);
		em.persist(p);
		return p.getId();
	}

	public Person getPerson(long id) {
		return em.find(Person.class,id);		
	}

	public void updatePerson(long id, String name, String surname) {
		Person p =  em.find(Person.class,id);
		p.setName(name);
		p.setSurname(surname);
		
	}

	public void deletePerson(long id) {
		Person p =  em.find(Person.class,id);
		em.remove(p);		
	}

	public Integer createData(String value, String type) {
		// TODO Auto-generated method stub
		Data d = new Data();
		d.setType(type);
		d.setValue(value);
		em.persist(d);
		return d.getId();
	}
	

}
