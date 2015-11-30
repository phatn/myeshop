package com.myeshop.dao;

import com.myeshop.domain.Customer;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public interface CustomerDao {
	
	public Customer getCustomerByUsername(String userName);
	
	public void register(Customer customer);
	
	public void update(Customer customer);
	
}
