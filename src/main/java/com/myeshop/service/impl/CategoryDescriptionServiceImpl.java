package com.myeshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myeshop.dao.CategoryDescriptionDao;
import com.myeshop.domain.CategoryDescription;
import com.myeshop.service.CategoryDescriptionService;
import com.myeshop.service.TransactionalAspectAwareService;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Service("categoryDescriptionService")
public class CategoryDescriptionServiceImpl implements CategoryDescriptionService, TransactionalAspectAwareService {
	
	@Autowired
	private  CategoryDescriptionDao categoryDescriptionDao;

	@Override
	public CategoryDescription findByCategoryID(Long categoryId,
			String languageCode) {
		return categoryDescriptionDao.findByCategoryID(categoryId, languageCode);
	}
}
