package com.kiran.software.entity;

import java.math.BigDecimal;
import java.util.Currency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="Customer")
public class Customer {
	
	@Column(name="ANNUAL_SALARY", nullable=false)
	@Type(type="big_decimal")
	public BigDecimal getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(BigDecimal annualSalary) {
		this.annualSalary = annualSalary;
	}
	
	public void setAnnualSalary(double annualSalary) {
		this.setAnnualSalary(new BigDecimal(annualSalary));
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUSTOMER_ID")
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Column(name="CUSTOMER_NAME")
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@OneToOne()
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account accounts) {
		this.account = accounts;
	}
	
	private String customerName;
	
	private int customerId;

	private BigDecimal annualSalary;
	
	private Account account;
}
