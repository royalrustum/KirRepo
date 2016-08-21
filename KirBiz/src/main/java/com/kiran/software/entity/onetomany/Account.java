package com.kiran.software.entity.onetomany;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.kiran.software.entity.onetomany.Customer;

@Entity
@Table(name="Account")
public class Account {
 private int accountNumber;
 
 private String accountType;
 
 private Customer customer;

 //@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
/*public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}*/

@Id
 //@GenericGenerator(name="hilo-gen", strategy="hilo")
 @SequenceGenerator(sequenceName="AccountNo", initialValue=1, schema="Kiran", name="AccountNo-Sequence")
 @GeneratedValue(strategy=GenerationType.AUTO, generator="AccountNo-Sequence")
 @Column(name="ACCOUNT_NO")

public int getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(int accountNumber) {
	this.accountNumber = accountNumber;
}

public String getAccountType() {
	return accountType;
}

public void setAccountType(String accountType) {
	this.accountType = accountType;
}
 
}
