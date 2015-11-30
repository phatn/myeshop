package com.myeshop.web.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.myeshop.domain.Customer;
import com.myeshop.domain.User;
import com.myeshop.web.service.security.CustomerDetailsAdapter;
import com.myeshop.web.service.security.UserDetailsAdapter;

public class UserUtils {
	
	private UserUtils() {}
	
	public static Authentication getLoggedInAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	public static Customer getLoggedInCustomer() {
		CustomerDetailsAdapter customerDetailsAdapter = (CustomerDetailsAdapter)getLoggedInAuthentication().getPrincipal();
		if(customerDetailsAdapter != null)
			return customerDetailsAdapter.getCustomer();
		return null;
	}
	
	public static User getLoggedInUser() {
		UserDetailsAdapter userDetailsAdapter = (UserDetailsAdapter)getLoggedInAuthentication().getPrincipal();
		if(userDetailsAdapter != null)
			return userDetailsAdapter.getUser();
		return null;
	}
}
