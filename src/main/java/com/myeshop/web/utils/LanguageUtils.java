package com.myeshop.web.utils;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.myeshop.domain.Language;
import com.myeshop.service.LanguageService;
import com.myeshop.web.contants.Constant;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Component
public class LanguageUtils {
	
	@Autowired
	private LanguageService languageService; 
	
	public Language getRequestLanguage(HttpServletRequest request) {
		Language language = (Language)request.getSession().getAttribute(Constant.LANGUAGE);
		if(language == null) {
			Locale locale = LocaleContextHolder.getLocale();
			if(locale != null) {
				language = languageService.getLanguage(locale);
			}
			if(language == null) {
				language = languageService.findByCode(Constant.DEFAULT_LANGUAGE);
			}
				
			request.getSession().setAttribute(Constant.LANGUAGE, language);
		}
		return language;
	}

	public LanguageService getLanguageService() {
		return languageService;
	}

	public void setLanguageService(LanguageService languageService) {
		this.languageService = languageService;
	}
}
