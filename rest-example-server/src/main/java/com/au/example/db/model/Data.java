package com.au.example.db.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "Data")
public class Data implements BaseModel<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequenceName", value = "sequence"),
			@org.hibernate.annotations.Parameter(name = "allocationSize", value = "1"), })
	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@OneToMany(mappedBy = "data",fetch=FetchType.EAGER,cascade = {CascadeType.ALL})
	private Set<DataDetial> detialSet;
	
	@OneToOne(mappedBy= "dataOne", fetch=FetchType.EAGER,cascade = {CascadeType.ALL})
	private DataDetial dataDetial;

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

	public Set<DataDetial> getDetialSet() {
		return detialSet;
	}

	public void setDetialSet(Set<DataDetial> detialSet) {
		this.detialSet = detialSet;
	}

	public DataDetial getDataDetial() {
		return dataDetial;
	}

	public void setDataDetial(DataDetial dataDetial) {
		this.dataDetial = dataDetial;
	}

}
