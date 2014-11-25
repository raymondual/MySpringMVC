package com.moon.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.moon.dao.CustomerDAO;
import com.moon.domain.Customers;

@Service("customerService")
public class CustomerService {

	@Resource(name = "customerDAO")
	private CustomerDAO customerDAO;

	public List<Customers> getCustomers() {
		return customerDAO.get("from Customers", new Object[] {});
	}
	
	@SuppressWarnings("unchecked")
	public List<Customers> loadCustomers() {
		String hql = "from Customers order by id";
		return (List<Customers>)customerDAO.load(hql);
	}
	
	public Customers getCustomer() {
		return (Customers)customerDAO.get(new Long(1));
	}
	
	public Customers loadCustomer() {
		return (Customers)customerDAO.load(new Long(1));
	}

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

}
