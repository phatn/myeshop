package com.myeshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myeshop.dao.CustomerDao;
import com.myeshop.domain.Customer;
import com.myeshop.service.CustomerService;
import com.myeshop.service.TransactionalAspectAwareService;
import com.myeshop.web.utils.PasswordEncoderUtils;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Service("customerService")
public class CustomerServiceImpl implements CustomerService, TransactionalAspectAwareService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Customer getCustomerByUsername(String userName) {
		return customerDao.getCustomerByUsername(userName);
	}

	@Override
	public void register(Customer customer) {
		customer.setPassword(PasswordEncoderUtils.encode(customer.getPassword()));
		customerDao.register(customer);
	}
	
	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}
}
