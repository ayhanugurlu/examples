package com.au.example.inheritance.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.au.example.inheritance.util.RestCustomMapper;


@XmlRootElement
public class Bird extends Animal {

	private Boolean flying;

	public Boolean getFlying() {
		return flying;
	}

	public void setFlying(Boolean flying) {
		this.flying = flying;
	}

}
