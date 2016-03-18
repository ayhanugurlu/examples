package com.au.example.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "Data_Detial")
public class DataDetial implements BaseModel<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "sequencedetial", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequenceNameDetial", value = "sequencedetial"),
			@org.hibernate.annotations.Parameter(name = "allocationSize", value = "1"), })
	@GeneratedValue(generator = "sequencedetial", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name = "value")
	private String value;
	
	@ManyToOne
    @JoinColumn(name="DATA_ID", nullable=false)
	private Data data;
	
	@OneToOne
    @JoinColumn(name="DATA_ONE_ID", nullable=false)
	private Data dataOne;

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

	public Data getDataOne() {
		return dataOne;
	}

	public void setDataOne(Data dataOne) {
		this.dataOne = dataOne;
	}



}
