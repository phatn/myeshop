package com.myeshop.dao.impl;

import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.myeshop.dao.AbstractGenericDao;
import com.myeshop.dao.CustomerDao;
import com.myeshop.domain.Customer;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractGenericDao<Customer> implements
		CustomerDao {
	
	@Override
	public Customer getCustomerByUsername(String userName) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select c from Customer c join fetch c.roles r where c.userName = :userName");
		TypedQuery<Customer> query = getEntityManager().createQuery(queryBuilder.toString(), Customer.class);
		query.setParameter("userName", userName);
		return query.getSingleResult();
	}
	
	@Override
	public void register(Customer customer) {
		create(customer);
	}
}
