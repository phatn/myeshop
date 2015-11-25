package com.myeshop.dao;

import com.myeshop.domain.Language;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public interface LanguageDao extends GenericDao<Language> {
	
	public Language findByCode(String code);
}
