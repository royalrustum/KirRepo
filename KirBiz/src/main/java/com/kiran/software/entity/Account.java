package com.kiran.software.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ACCOUNT")
public class Account {
 private int accountNumber;
 
 private String accountType;

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
