package com.au.example.db.model;

public class BaseModel<T> {
	
	T id;

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}
	
	

}
