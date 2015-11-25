package com.myeshop.dao;

import java.util.List;
import com.myeshop.domain.ProductRelationship;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public interface ProductRelationshipDao {

	public List<ProductRelationship> getByProductId(Long id);
}
