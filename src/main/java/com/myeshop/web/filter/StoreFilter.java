package com.myeshop.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.myeshop.web.contants.Constant;
import com.myeshop.web.utils.LanguageUtils;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public class StoreFilter extends HandlerInterceptorAdapter {
	
	@Autowired
	private LanguageUtils languageUtils;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		com.myeshop.domain.Language language = languageUtils.getRequestLanguage(request);
		request.setAttribute(Constant.LANGUAGE, language);
		return true;
	}

	public LanguageUtils getLanguageUtils() {
		return languageUtils;
	}

	public void setLanguageUtils(LanguageUtils languageUtils) {
		this.languageUtils = languageUtils;
	}
}
