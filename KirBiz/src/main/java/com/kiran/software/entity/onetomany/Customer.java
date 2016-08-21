package com.kiran.software.entity.onetomany;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
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

	//@OneToMany(fetch=FetchType.LAZY) // With Bridge
	//@OneToMany(fetch=FetchType.LAZY, mappedBy="customer", cascade=CascadeType.ALL) // Without Bridge - Bi Directional
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
            name="CustAccounts",
            joinColumns = @JoinColumn( name="Cust_Id"),
            inverseJoinColumns = @JoinColumn( name="Account_Id")
    )
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	private List<Account> accounts = new ArrayList<Account>();
	
	private String customerName;
	
	private int customerId;

	private BigDecimal annualSalary;
}
