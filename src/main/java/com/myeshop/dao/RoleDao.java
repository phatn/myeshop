package com.myeshop.dao;

import com.myeshop.domain.Role;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public interface RoleDao {
	
	public Role getRoleByName(String roleName);
}
