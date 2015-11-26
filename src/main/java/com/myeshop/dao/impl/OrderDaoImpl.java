package com.myeshop.dao.impl;

import org.springframework.stereotype.Repository;

import com.myeshop.dao.AbstractGenericDao;
import com.myeshop.dao.OrderDao;
import com.myeshop.domain.Order;

@Repository("orderDao")
public class OrderDaoImpl extends AbstractGenericDao<Order> implements OrderDao {
	
	@Override
	public void create(Order order) {
		super.create(order);
	}
}
