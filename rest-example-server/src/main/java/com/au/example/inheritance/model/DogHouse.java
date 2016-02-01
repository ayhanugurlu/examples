package com.au.example.inheritance.model;

import com.au.example.inheritance.util.RestCustomMapper;

@RestCustomMapper
public class DogHouse {
	
	private Dog dog;

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}
	
	

}
