package com.ayhan.inheritance.model;

import com.ayhan.inheritance.util.RestCustomMapper;

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
