package com.myeshop.service;

import java.util.List;
import com.myeshop.domain.ProductRelationship;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public interface ProductRelationshipService {
	
	public List<ProductRelationship> getByProductId(Long id);
	
}
