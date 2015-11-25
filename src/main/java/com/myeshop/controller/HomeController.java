package com.myeshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myeshop.domain.Category;
import com.myeshop.domain.Language;
import com.myeshop.service.CategoryService;
import com.myeshop.service.ProductService;
import com.myeshop.web.contants.Constant;
import com.myeshop.web.entity.Cart;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Controller
public class HomeController {
	
	private static Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/")
	public String home(Model model, HttpServletRequest request) {
		logger.info("Home controller");
		Language language = (Language)request.getAttribute(Constant.LANGUAGE);
		@SuppressWarnings("unchecked")
		List<Category> categories = (List<Category>)request.getSession().getAttribute("categories");
		if(categories == null) {
			categories = categoryService.getAllRootCategories(language);
			request.getSession().setAttribute("categories", categories);
		}
		model.addAttribute("categories", categories);
		model.addAttribute("featuredProducts", productService.getFeaturedProducts());
		model.addAttribute("cart", cart);
		
		return "home";
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
}
