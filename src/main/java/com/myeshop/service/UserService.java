package com.myeshop.service;

import com.myeshop.domain.User;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public interface UserService {
	
	public User getUserByUsername(String userName);
	
}
