package com.kiran.software.entity.inherit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@SuppressWarnings("deprecation")
@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE) // Single table- With All columns of Child classes. 
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) // Multiple tables- With Child tables having the columns of parent class.
@Inheritance(strategy=InheritanceType.JOINED)
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
public class Vehicle {

	@Id
	@SequenceGenerator(name="vehicle_seq", initialValue=1, allocationSize=1, sequenceName="vehicle_seq")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="vehicle_seq")
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	private int vehicleId;
	
	private String vehicleName;
}
