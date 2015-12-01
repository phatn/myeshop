package com.myeshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myeshop.dao.CategoryDao;
import com.myeshop.domain.Category;
import com.myeshop.domain.Language;
import com.myeshop.service.CategoryService;
import com.myeshop.service.TransactionalAspectAwareService;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService, TransactionalAspectAwareService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> getAll(Language language) {
		return categoryDao.getAll(language);
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Category> getAllByCode(String code) {
		return categoryDao.getAllByCode(code);
	}


	@Override
	public Category getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAllRootCategories(Language language) {
		return categoryDao.getAllRootCategories(language); 
	}
	
	@Override
	public List<Category> getAllRootCategories(String languageCode) {
		return categoryDao.getAllRootCategories(languageCode);
	}

	@Override
	public Category getBySefUrl(String sefUrl, Language language) {
		return categoryDao.getBySefUrl(sefUrl, language);
	}

	@Override
	public Category getById(Long categoryId, Language language) {
		return categoryDao.getById(categoryId, language);
	}

	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}

	@Override
	public void create(Category category) {
		categoryDao.create(category);
	}
}
