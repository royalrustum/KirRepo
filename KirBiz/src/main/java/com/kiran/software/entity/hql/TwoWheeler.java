package com.kiran.software.entity.hql;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@NamedQuery(name="TwoWheeler.byId", query = "from TwoWheeler where vehicleId > :fromVehicleId")
public class TwoWheeler extends Vehicle {

	public String getDrivingHandle() {
		return drivingHandle;
	}

	public void setDrivingHandle(String drivingHandle) {
		this.drivingHandle = drivingHandle;
	}
	
	private String drivingHandle;

}
