package com.au.example.db.common.dialect;

public enum Driver {
	
	SQLSERVER("com.microsoft.sqlserver.jdbc.SQLServerDriver"),MYSQL("com.mysql.jdbc.Driver"),H2("org.h2.Driver");
	
	private String value;
	
	private Driver(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}

}

