package com.myeshop.service;

import com.myeshop.domain.CategoryDescription;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public interface CategoryDescriptionService {
	public CategoryDescription findByCategoryID(Long categoryId, String languageCode);
}
