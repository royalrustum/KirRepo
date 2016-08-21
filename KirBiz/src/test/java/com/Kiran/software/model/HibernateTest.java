package com.Kiran.software.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.Test;

import com.kiran.software.entity.manytomany.Group;
import com.kiran.software.entity.manytomany.Student;

public class HibernateTest {
	
	/*@Test*/
	public void CreateCustomer_OneToOne() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		com.kiran.software.entity.onetoone.Account account = new com.kiran.software.entity.onetoone.Account();
		account.setAccountType("Savings");
		
		com.kiran.software.entity.onetoone.Account account1 = new com.kiran.software.entity.onetoone.Account();
		account1.setAccountType("Current");
		
		com.kiran.software.entity.onetoone.Customer customer = new com.kiran.software.entity.onetoone.Customer();
		customer.setCustomerName("Kiran Kumar Raju Valivarthi");
		customer.setAnnualSalary(100000);
	
		customer.setAccount(account);
		
		account.setCustomer(customer);
		account1.setCustomer(customer);
		
		session.save(customer);
		session.save(account);
		session.save(account1);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	/*@Test*/
	public void CreateCustomer_OneToMany_BridgeTable() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		com.kiran.software.entity.onetomany.Account account = new com.kiran.software.entity.onetomany.Account();
		account.setAccountType("Savings");
		
		com.kiran.software.entity.onetomany.Account account1 = new com.kiran.software.entity.onetomany.Account();
		account1.setAccountType("Current");
		
		com.kiran.software.entity.onetomany.Customer customer = new com.kiran.software.entity.onetomany.Customer();
		customer.setCustomerName("Kiran Kumar Raju Valivarthi");
		customer.setAnnualSalary(100000);
	
		//account.setCustomer(customer);
		//account1.setCustomer(customer);
		customer.getAccounts().add(account);
		customer.getAccounts().add(account1);
		
		
		session.save(customer);
		session.save(account);
		session.save(account1);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	//@Test
	public void CreateCustomer_OneToMany_WithoutBridgeTable() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		com.kiran.software.entity.onetomany.Account account = new com.kiran.software.entity.onetomany.Account();
		account.setAccountType("Savings");
		
		com.kiran.software.entity.onetomany.Account account1 = new com.kiran.software.entity.onetomany.Account();
		account1.setAccountType("Current");
		
		com.kiran.software.entity.onetomany.Customer customer = new com.kiran.software.entity.onetomany.Customer();
		customer.setCustomerName("Kiran Kumar Raju Valivarthi");
		customer.setAnnualSalary(100000);
	
		//account.setCustomer(customer);
		//account1.setCustomer(customer);
		customer.getAccounts().add(account);
		customer.getAccounts().add(account1);
		
		
		session.save(customer);
		session.save(account);
		session.save(account1);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void CreateCustomer_ManyToMany_BridgeTable() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Student student1 = new Student();
		student1.setStudentName("Kiran");
		
		Student student2 = new Student();
		student2.setStudentName("Satyavathi");
		
		Group group1 = new Group();
		group1.setGroupName("Kandulur");
		
		Group group2 = new Group();
		group2.setGroupName("BZA");
		
		student1.getGroups().add(group1);
		student1.getGroups().add(group2);
		
		student2.getGroups().add(group2);
		student2.getGroups().add(group1);
		
		group1.getStudents().add(student1);
		group1.getStudents().add(student2);
		
		group2.getStudents().add(student2);
		group2.getStudents().add(student1);
		
		session.save(student1);
		session.save(group1);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
