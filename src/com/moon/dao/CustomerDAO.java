package com.moon.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.moon.domain.Customers;

@Component("customerDAO")
public class CustomerDAO extends AbstractDao<Customers> {

	public CustomerDAO() {
		super(Customers.class);
	}

	public List<?> load(String hql) {
		return (List<?>) getCurrentSession().createCriteria(Customers.class);
	}
}
