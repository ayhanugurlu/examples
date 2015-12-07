package com.ayhan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Point;

@Entity
@Table(name = "Location")
public class Location {

	@Id
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequenceName", value = "sequence"),
			@org.hibernate.annotations.Parameter(name = "allocationSize", value = "1"), })
	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "LOCATION")
	@Type(type = "org.hibernate.spatial.GeometryType")
	private Point location;

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

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

}
