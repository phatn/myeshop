package com.myeshop.dao.impl;

import org.springframework.stereotype.Repository;
import com.myeshop.dao.AbstractGenericDao;
import com.myeshop.dao.LanguageDao;
import com.myeshop.domain.Language;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Repository("languageDao")
public class LanguageDaoImpl  extends AbstractGenericDao<Language> implements LanguageDao {

	@Override
	public Language findByCode(String code) {
		return getEntityManager().
				createQuery("from Language lan where lan.code = :code", Language.class).
				setParameter("code", code).getSingleResult();
	}
}
