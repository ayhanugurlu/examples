package com.au.example.inheritance.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dog extends Mammal {
	private String barksAlot;

	public String getBarksAlot() {
		return barksAlot;
	}

	public void setBarksAlot(String barksAlot) {
		this.barksAlot = barksAlot;
	}

}
