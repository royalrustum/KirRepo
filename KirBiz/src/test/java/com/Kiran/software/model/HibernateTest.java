package com.Kiran.software.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.Test;

import com.kiran.software.entity.Account;
import com.kiran.software.entity.Customer;

public class HibernateTest {
	
	@Test
	public void CreateCustomer() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCustomerName("Kiran Kumar Raju Valivarthi");
		customer.setAnnualSalary(100000);
		
		Account account = new Account();
		account.setAccountType("Savings");
		
		Account account1 = new Account();
		account1.setAccountType("Current");
		
		customer.setAccount(account);
		
		session.save(customer);
		session.save(account);
		session.save(account1);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
