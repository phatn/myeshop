package com.myeshop.web.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.myeshop.domain.Customer;
import com.myeshop.service.CustomerService;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Service("customerDetailsService")
public class CustomerDetailsServiceAdapter implements UserDetailsService {

	@Autowired
	private CustomerService customerService;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Customer customer = customerService.getCustomerByUsername(username);
		if(customer == null) {
			throw new UsernameNotFoundException("No such user: " + username);
		} else if(customer.getRoles().isEmpty()) {
			throw new UsernameNotFoundException("User " + username + " has no authorities");
		}
		CustomerDetailsAdapter user = new CustomerDetailsAdapter(customer);
		return user;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
}
