package com.myeshop.dao.impl;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.myeshop.dao.AbstractGenericDao;
import com.myeshop.dao.RoleDao;
import com.myeshop.domain.Role;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Repository("roleDao")
public class RoleDaoImpl extends AbstractGenericDao<Role> implements RoleDao {
	public Role getRoleByName(String roleName) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select r from Role r where r.name = :roleName");
		TypedQuery<Role> query = getEntityManager().createQuery(queryBuilder.toString(), Role.class);
		query.setParameter("roleName", roleName);
		return query.getSingleResult();
	}
}
