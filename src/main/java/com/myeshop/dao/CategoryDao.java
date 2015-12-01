package com.myeshop.dao;

/**
 *  
 * @author Phat Nguyen
 * 
 */

import java.util.List;

import com.myeshop.domain.Category;
import com.myeshop.domain.Language;

public interface CategoryDao {
	
	public List<Category> getAll(Language language);
	
	public List<Category> getAllByCode(String LanguageCode);
	
	public Category getByName(String name);
	
	public List<Category> getAllRootCategories(Language language);
	
	public List<Category> getAllRootCategories(String languageCode);
	
	public Category getBySefUrl(String sefUrl, Language language);
	
	public Category getById(Long categoryId, Language language);
	
	public void update(Category category);
	
	public void create(Category category);
}
