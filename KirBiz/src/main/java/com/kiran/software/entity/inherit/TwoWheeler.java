package com.kiran.software.entity.inherit;

import javax.persistence.Entity;

@Entity
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
public class TwoWheeler extends Vehicle {

	public String getDrivingHandle() {
		return drivingHandle;
	}

	public void setDrivingHandle(String drivingHandle) {
		this.drivingHandle = drivingHandle;
	}
	
	private String drivingHandle;

}
