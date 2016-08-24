package com.kiran.software.entity.embed;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String zipcode;

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}
