package com.myeshop.service;

import java.util.List;
import java.util.Map;

import com.myeshop.domain.Category;
import com.myeshop.domain.Product;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public interface ProductService {
	
	public List<Product> getAllProducts();
	
	public Map<String, Object> getProductsByCategory(Category category, int start, int limit);
	
	public List<Product> getFeaturedProducts();
	
	public List<Product> getClearanceProducts();
	
	public List<Product> getNewReleaseProducts();
	
	public Product getById(Long id);
	
	public Product getSpecById(Long id);
	
	public List<Product> getByIds(List<Long> productIds);
}
