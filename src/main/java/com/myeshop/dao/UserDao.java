package com.myeshop.dao;

import com.myeshop.domain.User;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public interface UserDao {
	
	public User getUserByUsername(String userName);
}
