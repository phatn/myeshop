package com.myeshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myeshop.dao.ProductRelationshipDao;
import com.myeshop.domain.ProductRelationship;
import com.myeshop.service.ProductRelationshipService;
import com.myeshop.service.TransactionalAspectAwareService;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Service("productRelationshipService")
public class ProductRelationshipServiceImpl implements ProductRelationshipService, TransactionalAspectAwareService {

	@Autowired
	private ProductRelationshipDao productRelationshipDao;
	
	@Override
	public List<ProductRelationship> getByProductId(Long id) {
		return productRelationshipDao.getByProductId(id);
	}

}
