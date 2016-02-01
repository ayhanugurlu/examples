package com.au.example.inheritance.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.au.example.inheritance.util.RestCustomMapper;

@RestCustomMapper
@XmlRootElement
public class Animal {

	private String name;
	private String knowledge; 
	private String habitat ;
	private Double topSpeed; 
	private String color;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKnowledge() {
		return knowledge;
	}
	public void setKnowledge(String knowledge) {
		this.knowledge = knowledge;
	}
	public String getHabitat() {
		return habitat;
	}
	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}
	public Double getTopSpeed() {
		return topSpeed;
	}
	public void setTopSpeed(Double topSpeed) {
		this.topSpeed = topSpeed;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	} 
	
	
	
	
}
