package com.moon.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.moon.domain.Customers;
import com.moon.service.CustomerService;

@Controller
public class CustomerController {

	@Resource(name = "customerService")
	private CustomerService customerService;

	@RequestMapping(value = "customer")
	public ModelAndView search() {
		Customers customer = customerService.getCustomer();
		List<Customers> customers = Arrays.asList(customer);
		if (customers.size() > 0) {
			// ָ��Ҫ���ص�ҳ��Ϊsucc.jsp
			ModelAndView mav = new ModelAndView("customer");
			// ���������ظ�ҳ��
			mav.addObject("customers", customers);
			//mav.addObject("name", "example");
			return mav;
		}

		return new ModelAndView("customer");
	}
}
