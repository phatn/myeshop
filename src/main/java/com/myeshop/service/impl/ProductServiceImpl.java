package com.myeshop.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myeshop.dao.ProductDao;
import com.myeshop.domain.Category;
import com.myeshop.domain.Product;
import com.myeshop.service.ProductService;
import com.myeshop.service.TransactionalAspectAwareService;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Service("productService")
public class ProductServiceImpl implements ProductService, TransactionalAspectAwareService {
	
	@Autowired
	private ProductDao productDao;

	
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Override
	public Map<String, Object> getProductsByCategory(Category category, int start, int limit) {
		return productDao.getProductsByCategory(category, start, limit);
	}

	@Override
	public List<Product> getFeaturedProducts() {
		return productDao.getFeaturedProducts();
	}

	@Override
	public List<Product> getClearanceProducts() {
		return productDao.getClearanceProducts();
	}

	@Override
	public List<Product> getNewReleaseProducts() {
		return productDao.getNewReleaseProducts();
	}

	@Override
	public Product getById(Long id) {
		return productDao.getById(id);
	}

	@Override
	public Product getSpecById(Long id) {
		return productDao.getSpecById(id);
	}

	@Override
	public List<Product> getByIds(List<Long> productIds) {
		return productDao.getByIds(productIds);
	}
}
