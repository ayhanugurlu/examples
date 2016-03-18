package com.au.example.basedto.dto;

import com.au.example.basedto.core.BaseDto;

public class Car extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 673375255819152493L;

	private String name;

	private String model;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
