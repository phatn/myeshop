package com.myeshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myeshop.dao.OrderDao;
import com.myeshop.domain.Order;
import com.myeshop.service.OrderService;
import com.myeshop.service.TransactionalAspectAwareService;

@Service("orderService")
public class OrderServiceImpl implements OrderService, TransactionalAspectAwareService {

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public void create(Order order) {
		orderDao.create(order);
	}
}
