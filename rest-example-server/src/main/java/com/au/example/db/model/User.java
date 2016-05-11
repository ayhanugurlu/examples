package com.au.example.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "User")
public class User {
	
	
	@Id
	@GenericGenerator(name = "sequenceuser", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequenceNameuser", value = "sequenceuser"),
			@org.hibernate.annotations.Parameter(name = "allocationSize", value = "1"), })
	@GeneratedValue(generator = "sequenceuser", strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name ="USERNAME")
	private String username;
	
	@Column(name ="PASSWORD")
	private String password;
	
	@Column(name ="NAME")
	private String name;
	
	@Column(name ="SURNAME")
	private String surname;
	
	@Column(name ="MOTHERNAME")
	private String motherName;
	
	
	private String changetype;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getMotherName() {
		return motherName;
	}


	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}


	public String getChangetype() {
		return changetype;
	}


	public void setChangetype(String changetype) {
		this.changetype = changetype;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String userString = "Id "+id +",Name " +name+" ,Surname "+surname;
		return userString;
	}
	
	
	

}
