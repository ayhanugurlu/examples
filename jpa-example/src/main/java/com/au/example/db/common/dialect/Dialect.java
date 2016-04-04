package com.au.example.db.common.dialect;

public enum Dialect {

	SQLSERVER("org.hibernate.dialect.SQLServer2012Dialect"), MYSQL("org.hibernate.dialect.MySQL5Dialect"),H2("org.hibernate.dialect.H2Dialect");

	private String value;

	private Dialect(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

}