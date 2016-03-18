package com.au.example.basedto.core;

import java.io.Serializable;

public class BaseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ResponceStatus responceStatus;

	private String responceStatusExplanation;

	public ResponceStatus getResponceStatus() {
		return responceStatus;
	}

	public void setResponceStatus(ResponceStatus responceStatus) {
		this.responceStatus = responceStatus;
	}

	public String getResponceStatusExplanation() {
		return responceStatusExplanation;
	}

	public void setResponceStatusExplanation(String responceStatusExplanation) {
		this.responceStatusExplanation = responceStatusExplanation;
	}

}
