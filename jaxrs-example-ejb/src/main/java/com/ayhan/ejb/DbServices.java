package com.ayhan.ejb;

import javax.ejb.Local;

import com.ayhan.model.Location;

@Local
public interface DbServices {
	
	public void create(Location location);
	
	public Location find(Location location) ;
}
