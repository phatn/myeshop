package com.myeshop.dao.impl;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.myeshop.dao.AbstractGenericDao;
import com.myeshop.dao.CategoryDao;
import com.myeshop.domain.Category;
import com.myeshop.domain.Language;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractGenericDao<Category> implements CategoryDao {

	@Override
	public List<Category> getAll(Language language) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select c from Category c join fetch c.descriptions cd");
		queryBuilder.append(" join cd.language lang where lang.code = :languageCode");
		TypedQuery<Category> query = getEntityManager().createQuery(queryBuilder.toString(), Category.class);
		query.setParameter("languageCode", language.getCode());
		return query.getResultList();
	}

	@Override
	public List<Category> getAllByCode(String code) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select c from Category c join fetch c.descriptions cd");
		queryBuilder.append(" join cd.language lang where lang.code = :languageCode");
		TypedQuery<Category> query = getEntityManager().createQuery(queryBuilder.toString(), Category.class);
		query.setParameter("languageCode", code);
		return query.getResultList();
	}

	@Override
	public Category getByName(String name) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select c from Category c left join fetch c.descriptions cd");
		queryBuilder.append(" where cd.name = :name");
		TypedQuery<Category> query = getEntityManager().createQuery(queryBuilder.toString(), Category.class);
		query.setParameter("name", name);
		return query.getSingleResult(); 
	}
	
	@Override
	public List<Category> getAllRootCategories(Language language) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select DISTINCT c from Category c left join fetch c.categories cats ");
		queryBuilder.append("join fetch c.descriptions cd ");
		queryBuilder.append("join cd.language lang where lang.code = :languageCode");
		TypedQuery<Category> query = getEntityManager().createQuery(queryBuilder.toString(), Category.class);
		query.setParameter("languageCode", language.getCode());
		List<Category> rootCategories = query.getResultList();
		Iterator<Category> iterator = rootCategories.iterator();
		
		while(iterator.hasNext()) {
			if(iterator.next().getParent() != null) {
				iterator.remove();
			}
		}
		return rootCategories;
	}
	
	
	@Override
	public List<Category> getAllRootCategories(String languageCode) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select DISTINCT c from Category c left join fetch c.categories cats ");
		queryBuilder.append("join fetch c.descriptions cd ");
		queryBuilder.append("join cd.language lang where lang.code = :languageCode");
		TypedQuery<Category> query = getEntityManager().createQuery(queryBuilder.toString(), Category.class);
		query.setParameter("languageCode", languageCode);
		List<Category> rootCategories = query.getResultList();
		Iterator<Category> iterator = rootCategories.iterator();
		
		while(iterator.hasNext()) {
			if(iterator.next().getParent() != null) {
				iterator.remove();
			}
		}
		return rootCategories;
	}

	@Override
	public Category getBySefUrl(String sefUrl, Language language) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select c from Category c left join fetch c.descriptions cd join cd.language lang ");
		queryBuilder.append("where cd.sefUrl = :sefUrl and lang.code = :languageCode");
		TypedQuery<Category> query = getEntityManager().createQuery(queryBuilder.toString(), Category.class);
		query.setParameter("sefUrl", sefUrl);
		query.setParameter("languageCode", language.getCode());
		return query.getSingleResult(); 
	}
	
}
