package com.myeshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myeshop.dao.RoleDao;
import com.myeshop.domain.Role;
import com.myeshop.service.RoleService;
import com.myeshop.service.TransactionalAspectAwareService;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Service("roleService")
public class RoleServiceImpl implements RoleService, TransactionalAspectAwareService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Role getRoleByName(String roleName) {
		return roleDao.getRoleByName(roleName);
	}
}
