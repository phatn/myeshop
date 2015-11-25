package com.myeshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myeshop.dao.UserDao;
import com.myeshop.domain.User;
import com.myeshop.service.TransactionalAspectAwareService;
import com.myeshop.service.UserService;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Service("userService")
public class UserServiceImpl implements UserService, TransactionalAspectAwareService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUserByUsername(String userName) {
		return userDao.getUserByUsername(userName);
	}
}
