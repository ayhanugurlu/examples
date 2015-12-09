package com.ayhan.services.dom;

import com.ayhan.util.RestCustomMapper;


@RestCustomMapper
public class Bird extends Animal {

	private Boolean flying;

	public Boolean getFlying() {
		return flying;
	}

	public void setFlying(Boolean flying) {
		this.flying = flying;
	}

}
