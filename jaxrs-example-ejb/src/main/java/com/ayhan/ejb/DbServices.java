package com.ayhan.ejb;

import javax.ejb.Local;

import com.ayhan.model.Location;
import com.ayhan.model.Person;

@Local
public interface DbServices {
	
	public long create(Location location);
	
	public Location find(long locationId) ;
	
	public long createPerson(String name,String surname) ;
	
	public Person getPerson(long id) ;
	
	public void deletePerson(long id) ;
	
	public void updatePerson(long id,String name,String surname) ;
	
	public Integer createData(String value,String type) ;
}
