package com.au.example.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "Data_Other_Detial")
public class DataOtherDetial {

	@Id
	@GenericGenerator(name = "sequenceotherdetial", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequenceNameOtherDetial", value = "sequenceotherdetial"),
			@org.hibernate.annotations.Parameter(name = "allocationSize", value = "1"), })
	@GeneratedValue(generator = "sequenceotherdetial", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name = "value")
	private String value;
	
	@OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="DATA")
	private Data data;

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

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}



}
