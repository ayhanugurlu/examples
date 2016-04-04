package com.au.example.db.common.dialect;

public enum Mode {

	VALIDATE("validate"), UPDATE("update"), CREATE("create"), CREATEDROP("create-drop");

	private String value;

	private Mode(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

}