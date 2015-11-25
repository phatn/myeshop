package com.myeshop.dao;

import com.myeshop.domain.CategoryDescription;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public interface CategoryDescriptionDao {
	
	public CategoryDescription findByCategoryID(Long categoryId, String languageCode);
}
