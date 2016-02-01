package com.au.example.inheritance.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.au.example.inheritance.util.RestCustomMapper;

@RestCustomMapper
@XmlRootElement
public class DogHouse {
	
	private Dog dog;

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}
	
	

}
