package com.au.example.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "Data")
public class Data {

	

	@Id
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequenceName", value = "sequence"),
			@org.hibernate.annotations.Parameter(name = "allocationSize", value = "1"), })
	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@OneToOne(mappedBy = "data", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private DataDetial dataDetial;
	
	@OneToOne(mappedBy = "data", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private DataOtherDetial dataOtherDetial;

	@Column(name = "value")
	private String value;

	@Column(name = "type")
	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	public DataDetial getDataDetial() {
		return dataDetial;
	}

	public void setDataDetial(DataDetial dataDetial) {
		this.dataDetial = dataDetial;
	}

	public DataOtherDetial getDataOtherDetial() {
		return dataOtherDetial;
	}

	public void setDataOtherDetial(DataOtherDetial dataOtherDetial) {
		this.dataOtherDetial = dataOtherDetial;
	}
	
	

}
