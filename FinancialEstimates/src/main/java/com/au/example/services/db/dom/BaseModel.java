package com.au.example.services.db.dom;

public class BaseModel<T> {
	
	T id;

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}
	
	

}
