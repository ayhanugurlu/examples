package com.au.example.db.entity.pktype;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;


@Audited
@Entity
@Table(name = "PK")
public class PK {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK_SEQ")
    @SequenceGenerator(name = "PK_SEQ", sequenceName = "pseq", initialValue = 1, allocationSize = 1)
	private long id;
	
	@Column
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
