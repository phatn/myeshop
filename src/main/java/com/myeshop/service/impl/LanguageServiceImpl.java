package com.myeshop.service.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myeshop.dao.LanguageDao;
import com.myeshop.domain.Language;
import com.myeshop.service.LanguageService;
import com.myeshop.service.TransactionalAspectAwareService;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Service("languageService")
public class LanguageServiceImpl implements LanguageService, TransactionalAspectAwareService {

	@Autowired
	private LanguageDao languageDao;
	
	@Override
	public Language getLanguage(Locale locale) {
		return languageDao.findByCode(locale.getLanguage());
	}

	@Override
	public Language findByCode(String code) {
		return languageDao.findByCode(code);
	}

	public LanguageDao getLanguageDao() {
		return languageDao;
	}

	public void setLanguageDao(LanguageDao languageDao) {
		this.languageDao = languageDao;
	}
}
