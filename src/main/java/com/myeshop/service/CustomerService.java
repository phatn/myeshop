package com.myeshop.service;

import com.myeshop.domain.Customer;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public interface CustomerService {
	
	public Customer getCustomerByUsername(String userName);
	
	public void register(Customer customer);
	
	public void update(Customer customer);
}
