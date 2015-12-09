package com.ayhan.services.dom;

import com.ayhan.util.RestCustomMapper;

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
