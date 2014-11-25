package com.moon.service;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.moon.domain.Address;
import com.moon.domain.Customers;

public class BusinessService {

	public static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		ServiceRegistryBuilder ssrb = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(ssrb
				.buildServiceRegistry());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BusinessService service = new BusinessService();

		Customers cust = new Customers();

		Address homeAddr = new Address();
		homeAddr.setId(3);
		homeAddr.setCity("Dalian");
		homeAddr.setProvince("Liaoning");
		homeAddr.setStreet("Chunianlu");
		homeAddr.setZipcode("116008");
		homeAddr.setCustomers(cust);

		Address comAddr = new Address();
		comAddr.setId(4);
		comAddr.setCity("Dalian");
		comAddr.setProvince("Liaoning");
		comAddr.setStreet("Huangpulu");
		comAddr.setZipcode("116085");
		comAddr.setCustomers(cust);

		cust.setId(2);
		cust.setName("MinLiang");
		cust.setHomeAddress(homeAddr);
		cust.setComAddress(comAddr);

		service.loadCustomers();
		System.out.println("Done~!");
		sessionFactory.close();
	}

	public void saveCustomers(Customers customer) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
	}

	public void loadCustomers() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Address addr = (Address) session.load(Address.class, new Integer(
				4));
		System.out.println("get homeAddr ---> " + addr.toString());
		System.out.println("get cust ---> " + addr.getCustomers().toString());
		
		tx.commit();
		
	}
}
