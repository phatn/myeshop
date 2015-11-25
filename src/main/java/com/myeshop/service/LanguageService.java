package com.myeshop.service;

import java.util.Locale;
import com.myeshop.domain.Language;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public interface LanguageService {
	
	public Language getLanguage(Locale locale);
	
	public Language findByCode(String code);
	
}