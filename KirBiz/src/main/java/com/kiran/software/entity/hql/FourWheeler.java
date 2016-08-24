package com.kiran.software.entity.hql;

import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehicle {

	public String getDrivingWheel() {
		return drivingWheel;
	}

	public void setDrivingWheel(String drivingWheel) {
		this.drivingWheel = drivingWheel;
	}
	
	private String drivingWheel;

}
