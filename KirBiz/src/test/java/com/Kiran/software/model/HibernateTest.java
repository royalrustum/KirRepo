package com.Kiran.software.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.testng.annotations.Test;

import com.kiran.software.entity.inherit.FourWheeler;
import com.kiran.software.entity.inherit.TwoWheeler;
import com.kiran.software.entity.inherit.Vehicle;
import com.kiran.software.entity.manytomany.Group;
import com.kiran.software.entity.manytomany.Student;

public class HibernateTest {

	/* @Test */
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

	/* @Test */
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

		// account.setCustomer(customer);
		// account1.setCustomer(customer);
		customer.getAccounts().add(account);
		customer.getAccounts().add(account1);

		session.save(customer);
		session.save(account);
		session.save(account1);

		session.getTransaction().commit();
		session.close();

	}

	// @Test
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

		// account.setCustomer(customer);
		// account1.setCustomer(customer);
		customer.getAccounts().add(account);
		customer.getAccounts().add(account1);

		session.save(customer);
		session.save(account);
		session.save(account1);

		session.getTransaction().commit();
		session.close();

	}

	// @Test
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

	// @Test
	public void CreateStudent_Embed() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		com.kiran.software.entity.embed.Student student = new com.kiran.software.entity.embed.Student();
		student.setStudentName("Kiran");

		com.kiran.software.entity.embed.Address address = new com.kiran.software.entity.embed.Address();
		address.setZipcode("17011");

		com.kiran.software.entity.embed.Address address1 = new com.kiran.software.entity.embed.Address();
		address1.setZipcode("17012");

		// student.setAddress(address);
		student.getAddresses().add(address);
		student.getAddresses().add(address1);

		session.save(student);

		session.getTransaction().commit();
	}

	// @Test
	public void CreateVehicle_Inheritance() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("Scooty");
		twoWheeler.setDrivingHandle("Scooty Handle");

		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehicleName("Jeep");
		fourWheeler.setDrivingWheel("Jeep Steering");

		session.save(fourWheeler);
		session.save(twoWheeler);

		session.getTransaction().commit();
	}

	// @Test
	public void CreateVehicle_CRUD() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		for (int i = 0; i < 10; i++) {
			TwoWheeler twoWheeler = new TwoWheeler();
			twoWheeler.setVehicleName("Scooty" + i);
			twoWheeler.setDrivingHandle("Scooty Handle" + i);
			session.save(twoWheeler);
		}

		TwoWheeler twoWheeler = session.get(TwoWheeler.class, 10);
		twoWheeler.setDrivingHandle("Scooty Handle 007");
		session.delete(twoWheeler);
		if (twoWheeler != null)
			System.out.println("Search:" + twoWheeler.getVehicleName());
		session.getTransaction().commit();
	}

	// @Test
	public void CreateVehicle_StateManagement() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		TwoWheeler twoWheeler = session.get(TwoWheeler.class, 20);

		if (twoWheeler != null)
			System.out.println("Search:" + twoWheeler.getVehicleName());

		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();

		session.beginTransaction();
		session.update(twoWheeler);
		session.getTransaction().commit();

		session.close();
	}

	// @Test
	public void CreateVehicle_HQL() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		com.kiran.software.entity.hql.TwoWheeler twoWheeler = session
				.get(com.kiran.software.entity.hql.TwoWheeler.class, 20);

		Query<TwoWheeler> query = session.createNamedQuery("TwoWheeler.byId");
		query.setInteger("fromVehicleId", 150);
		// query.list();

		query.setFirstResult(5);
		System.out.println("Count: " + query.list().size());
		session.getTransaction().commit();
		session.close();

	}

	// @Test
	public void CreateVehicle_Criteria() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		com.kiran.software.entity.hql.TwoWheeler twoWheelerEx = new com.kiran.software.entity.hql.TwoWheeler();
		twoWheelerEx.setDrivingHandle("Scooty Handle8");
		Example ex = Example.create(twoWheelerEx);

		Criteria criteria = session.createCriteria(com.kiran.software.entity.hql.TwoWheeler.class);
		// List twoWheelers = criteria.add(Restrictions.ilike("drivingHandle",
		// "%Scooty Handle8%")).list();
		// List twoWheelers = criteria.list();
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.property("vehicleId"));
		projList.add(Projections.property("drivingHandle"));
		criteria = criteria.setProjection(projList);
		List twoWheelers = criteria.add(ex).list();

		System.out.println("Count: " + twoWheelers.size());

		session.getTransaction().commit();
		session.close();

	}

	@Test
	public void CreateVehicle_Cache() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		/*com.kiran.software.entity.hql.TwoWheeler twoWheelerEx = new com.kiran.software.entity.hql.TwoWheeler();
		twoWheelerEx.setDrivingHandle("Scooty Handle8");*/
		//Example ex = Example.create(twoWheelerEx);

		/*Criteria criteria = session.createCriteria(com.kiran.software.entity.hql.TwoWheeler.class);
		// List twoWheelers = criteria.add(Restrictions.ilike("drivingHandle",
		// "%Scooty Handle8%")).list();
		// List twoWheelers = criteria.list();
		List twoWheelers = criteria.add(ex).list();
		System.out.println("Count: " + twoWheelers.size());*/

		/*com.kiran.software.entity.hql.TwoWheeler tw = session.get(com.kiran.software.entity.hql.TwoWheeler.class, 22);*/
		
		Query query = session.createQuery("from TwoWheeler where vehicleId < 5");
		query.setCacheable(true);
		query.list();
		
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();

		session.beginTransaction();

		query = session.createQuery("from TwoWheeler where vehicleId < 5");
		query.setCacheable(true);
		query.list();
		
		/*tw = session.get(com.kiran.software.entity.hql.TwoWheeler.class, 22);*/
		
		session.getTransaction().commit();
		session.close();
	}
}
