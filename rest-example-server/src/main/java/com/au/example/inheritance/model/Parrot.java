package com.au.example.inheritance.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Parrot extends Bird{

	private String vocabulary;

	public String getVocabulary() {
		return vocabulary;
	}

	public void setVocabulary(String vocabulary) {
		this.vocabulary = vocabulary;
	}

}
