package com.myeshop.dao.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.myeshop.dao.AbstractGenericDao;
import com.myeshop.dao.ProductDao;
import com.myeshop.domain.Category;
import com.myeshop.domain.ImageSize;
import com.myeshop.domain.Product;
import com.myeshop.web.contants.Constant;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Repository("productDao")
public class ProductDaoImpl extends AbstractGenericDao<Product> implements
		ProductDao {

	@Override
	public Map<String, Object> getProductsByCategory(Category category, int start, int limit ) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select DISTINCT p from Product p ");
		queryBuilder.append("join fetch p.attributes a join fetch a.attributeValues av ");
		queryBuilder.append("join fetch p.productImages i join  p.categories c  where i.imageSize = :imageSize ");
		queryBuilder.append("and a.name = :name and c.id = :categoryId");
		TypedQuery<Product> query = getEntityManager().createQuery(
				queryBuilder.toString(), Product.class);
		query.setParameter("name", "Name");
		query.setParameter("imageSize", ImageSize.SMALL);
		query.setParameter("categoryId", category.getId());
		List<Product> products = query.setFirstResult(start).setMaxResults(limit).getResultList();
		
		TypedQuery<Long> queryCount = getEntityManager().createQuery("select count(*) from Product p join p.categories c where c.id = :categoryId", Long.class);
		queryCount.setParameter("categoryId", category.getId());
		
		Long totalRecords = queryCount.getSingleResult();
		int totalPages = (int)Math.ceil(totalRecords.doubleValue() / Constant.PRODUCTS_PER_PAGE);
		System.out.println("Total records: " + totalRecords.longValue());
		System.out.println("Total pages: " + totalPages);
		Map<String, Object> productMap = new HashMap<>();
		productMap.put("products", products);
		productMap.put("totalPages", totalPages);
		return productMap;
	}

	@Override
	public List<Product> getProductsByCategories(Set<Long> categoryIds) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {
		return getEntityManager().createQuery("select p from Product p")
				.getResultList();
	}

	@Override
	public List<Product> getFeaturedProducts() {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("select DISTINCT p from Product p join fetch p.attributes a join fetch a.attributeValues av join fetch p.productImages i where i.imageSize = :imageSize and a.name = :name and p.featuredSeller is true");
		TypedQuery<Product> query = getEntityManager().createQuery(
				queryBuilder.toString(), Product.class);
		query.setParameter("name", "Name");
		query.setParameter("imageSize", ImageSize.SMALL);
		return query.getResultList();
	}

	@Override
	public List<Product> getClearanceProducts() {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("select DISTINCT p from Product p join fetch p.attributes a join fetch a.attributeValues av join fetch p.productImages i where i.imageSize = :imageSize and a.name = :name and p.clearance is true");
		TypedQuery<Product> query = getEntityManager().createQuery(
				queryBuilder.toString(), Product.class);
		query.setParameter("name", "Name");
		query.setParameter("imageSize", ImageSize.SMALL);
		return query.getResultList();
	}

	@Override
	public List<Product> getNewReleaseProducts() {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("select DISTINCT p from Product p join fetch p.attributes a join fetch a.attributeValues av join fetch p.productImages i where i.imageSize = :imageSize and a.name = :name and p.newRelease is true");
		TypedQuery<Product> query = getEntityManager().createQuery(
				queryBuilder.toString(), Product.class);
		query.setParameter("name", "Name");
		query.setParameter("imageSize", ImageSize.SMALL);
		return query.getResultList();
	}

	@Override
	public Product getById(Long id) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("select DISTINCT p from Product p join fetch p.attributes a join fetch a.attributeValues av join fetch p.productImages i where i.imageSize IN :imageSizes and a.name = :name and p.id = :id");
		TypedQuery<Product> query = getEntityManager().createQuery(
				queryBuilder.toString(), Product.class);
		query.setParameter("id", id);
		query.setParameter("name", "Name");
		query.setParameter("imageSizes", Arrays.asList(ImageSize.TINY, ImageSize.MEDIUM, ImageSize.BIG, ImageSize.SMALL));
		return query.getSingleResult();
	}

	@Override
	public Product getSpecById(Long id) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("select DISTINCT p from Product p join fetch p.attributes a join fetch a.attributeValues av where p.id = :id");
		TypedQuery<Product> query = getEntityManager().createQuery(
				queryBuilder.toString(), Product.class);
		query.setParameter("id", id);
		Product prod = query.getSingleResult();
		return prod;
	}

	@Override
	public Product getBySefUrl(String sefUrl) {
		
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
		.append("select DISTINCT p from Product p join fetch p.attributes a join fetch a.attributeValues av where p.sefUrl = :sefUrl");
		TypedQuery<Product> query = getEntityManager().createQuery(
		queryBuilder.toString(), Product.class);
		query.setParameter("sefUrl", sefUrl);
		return query.getSingleResult(); 
	}

	@Override
	public List<Product> getByIds(List<Long> productIds) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("select DISTINCT p from Product p join fetch p.attributes a join fetch a.attributeValues av join fetch p.productImages i where i.imageSize IN :imageSizes and a.name = :name and p.id IN :ids");
		TypedQuery<Product> query = getEntityManager().createQuery(
				queryBuilder.toString(), Product.class);
		query.setParameter("ids", productIds);
		query.setParameter("name", "Name");
		query.setParameter("imageSizes", Arrays.asList(ImageSize.TINY, ImageSize.MEDIUM, ImageSize.BIG, ImageSize.SMALL));
		List<Product> products = null;
		products = query.getResultList();
		return products;
	}
}
