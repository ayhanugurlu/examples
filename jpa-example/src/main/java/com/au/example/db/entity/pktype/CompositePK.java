package com.au.example.db.entity.pktype;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name = "CompositePK")
@IdClass(CompositeId.class)
public class CompositePK {

	@Id
	private long pk1;

	@Id
	private long pk2;

	@Column
	private String name;

	public long getPk1() {
		return pk1;
	}

	public void setPk1(long pk1) {
		this.pk1 = pk1;
	}

	public long getPk2() {
		return pk2;
	}

	public void setPk2(long pk2) {
		this.pk2 = pk2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
