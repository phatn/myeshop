package com.myeshop.dao.impl;

import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.myeshop.dao.AbstractGenericDao;
import com.myeshop.dao.UserDao;
import com.myeshop.domain.User;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Repository("userDao")
public class UserDaoImpl extends AbstractGenericDao<User> implements UserDao {

	@Override
	public User getUserByUsername(String userName) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select u from User u join fetch u.roles r where u.adminUserName = :userName");
		TypedQuery<User> query = getEntityManager().createQuery(queryBuilder.toString(), User.class);
		query.setParameter("userName", userName);
		return query.getSingleResult();
	}
}
