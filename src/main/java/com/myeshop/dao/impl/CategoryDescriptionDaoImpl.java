package com.myeshop.dao.impl;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.myeshop.dao.AbstractGenericDao;
import com.myeshop.dao.CategoryDescriptionDao;
import com.myeshop.domain.CategoryDescription;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Repository("categoryDescriptionDao")
public class CategoryDescriptionDaoImpl extends AbstractGenericDao<CategoryDescription> implements CategoryDescriptionDao {

	@Override
	public CategoryDescription findByCategoryID(Long categoryId,
			String languageCode) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select cd from CategoryDescription cd join cd.category join cd.language");
		queryBuilder.append(" where cd.category.id = :categoryId and cd.language.code = :languageCode");
		TypedQuery<CategoryDescription> query = getEntityManager().createQuery(queryBuilder.toString(), CategoryDescription.class);
		query.setParameter("categoryId", categoryId);
		query.setParameter("languageCode", languageCode);
		return query.getSingleResult();
	}
}
