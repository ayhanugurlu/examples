package com.ayhan.ejb;

import javax.ejb.Local;

import com.ayhan.model.Location;

@Local
public interface DbServices {
	
	public long create(Location location);
	
	public Location find(long locationId) ;
}
