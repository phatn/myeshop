package com.myeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myeshop.service.ProductService;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/edit/{productId}", method = RequestMethod.GET)
	public String add(@PathVariable("productId") Long productId) {
		return "editProduct";
	}
	
	@RequestMapping(value = "/delete/{productId}", method = RequestMethod.GET)
	public String delete(@PathVariable("productId") Long productId, @RequestParam("categoryId") Long categoryId, RedirectAttributes redir) {
		productService.deleteById(productId);
		redir.addFlashAttribute("message", "Delete successfully.");
		return "redirect:/admin/category/listProducts/" + categoryId;
	}
}
