package com.myeshop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
@RequestMapping("/product")
public class ProductController {

	private static final Logger logger = Logger.getLogger(ProductController.class);
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("list/{categorySefUrl}")
	public String listProducts(Model model, HttpServletRequest request, 
			@PathVariable("categorySefUrl") String categorySefUrl,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		logger.info("page = " + page);
		int start = (page - 1) * Constant.PRODUCTS_PER_PAGE;
		Language language = (Language)request.getAttribute(Constant.LANGUAGE);
		Category category = categoryService.getBySefUrl(categorySefUrl, language);
		logger.info("catId: " + category.getId());
		Map<String, Object> productMap = productService.getProductsByCategory(category, start, Constant.PRODUCTS_PER_PAGE);
		
		int totalPages = (int)productMap.get("totalPages");
		
		List<Integer> pages = new ArrayList<>();
		for(int i = 1; i <= totalPages; i++) {
			pages.add(i);
		}
		
		model.addAttribute("products", productMap.get("products"));
		model.addAttribute("pages", pages);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", page);
		model.addAttribute("categoryName", category.getDescription().getName());
		return "products";
	}
	
	@RequestMapping("/{prodId}")
	public String product(Model model, HttpServletRequest request, 
			@PathVariable("prodId") Long prodId ) {
		
		model.addAttribute("product", productService.getById(prodId));
		model.addAttribute("cart", cart);
		return "product";
	}
}
