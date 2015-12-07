package com.myeshop.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myeshop.domain.Category;
import com.myeshop.domain.CategoryDescription;
import com.myeshop.domain.Language;
import com.myeshop.domain.Product;
import com.myeshop.service.CategoryService;
import com.myeshop.service.ProductService;
import com.myeshop.web.contants.Constant;
import com.myeshop.web.entity.CategoryForm;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/list")
	public String list(Model model, HttpServletRequest request) {
		Language language = (Language)request.getAttribute(Constant.LANGUAGE);
		model.addAttribute("categories", categoryService.getAllRootCategories(language));
		return "adminCategory";
	}
	
	@RequestMapping("/edit/{categoryId}")
	public String edit(Model model, @PathVariable("categoryId") Long categoryId, HttpServletRequest request) {
		Language language = (Language)request.getAttribute(Constant.LANGUAGE);
		Category category = categoryService.getById(categoryId, language);
		CategoryForm form = toCategoryForm(category);
		model.addAttribute("category", form);
		return "editCategory";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editSubmit(@RequestParam("categoryId") Long categoryId, @ModelAttribute("category") @Valid CategoryForm form, 
			BindingResult result, HttpServletRequest request, RedirectAttributes redir) {
		
		if(result.hasErrors()) {
			return "editCategory";
		}
		
		Language language = (Language)request.getAttribute(Constant.LANGUAGE);
		Category category = categoryService.getById(categoryId, language);
		category.getDescription().setName(form.getName());
		category.getDescription().setDescription(form.getDescription());
		category.getDescription().setSefUrl(form.getSefUrl());
		category.setCode(form.getCode());
		categoryService.update(category);
		redir.addFlashAttribute("message", "Update " + category.getDescription().getName() + " category successfully.");
		return	"redirect:/admin/category/list";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model, HttpServletRequest request) {
		CategoryForm form = new CategoryForm();
		model.addAttribute("category", form);
		return "createCategory";
	}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createSubmit(Model model, HttpServletRequest request, RedirectAttributes redir, 
			@ModelAttribute("category") @Valid CategoryForm form, BindingResult result) {
		if(result.hasErrors()) {
			return "createCategory";
		}
		Language language = (Language)request.getAttribute(Constant.LANGUAGE);
		Category category = new Category();
		Set<CategoryDescription> catDescs = new HashSet<CategoryDescription>();
		CategoryDescription catDes = new CategoryDescription();
		catDes.setName(form.getName());
		catDes.setDescription(form.getDescription());
		catDes.setSefUrl(form.getSefUrl());
		catDes.setLanguage(language);
		catDes.setCategory(category);
		catDescs.add(catDes);
		category.setDescriptions(catDescs);
		category.setCode(form.getCode());
		categoryService.create(category);
		redir.addFlashAttribute("message", "Create " + form.getName() + " category successfully.");
		return	"redirect:/admin/category/list";
	}
	
	@RequestMapping(value = "/delete/{categoryId}", method = RequestMethod.POST)
	public String delete(@PathVariable("categoryId") Long categoryId, @RequestParam("categoryName") String categoryName, RedirectAttributes redir) {
		categoryService.deleteById(categoryId);
		redir.addFlashAttribute("message", "Delete " + categoryName + " successfully.");
		return	"redirect:/admin/category/list";
	}
	
	
	@RequestMapping(value = "/listProducts/{categoryId}", method = RequestMethod.GET)
	public String listProducts(@PathVariable("categoryId") Long categoryId, Model model) {
		List<Product> products = productService.getProductsByCategoryId(categoryId);
		model.addAttribute("products", products);
		model.addAttribute("categoryId", categoryId);
		return "productsInCategory";
	}
	
	private CategoryForm toCategoryForm(Category category) {
		CategoryForm form = new CategoryForm();
		form.setName(category.getDescription().getName());
		form.setDescription(category.getDescription().getDescription());
		//form.setImage(image);(category.getCategoryImage());
		form.setSefUrl(category.getDescription().getSefUrl());
		form.setId(category.getId());
		form.setCode(category.getCode());
		return form;
	}
	
//	private Category toCategory(CategoryForm form) {
//		Category category = new Category();
//		Set<CategoryDescription> catDescs = new HashSet<CategoryDescription>();
//		CategoryDescription catDes = new CategoryDescription();
//		catDes.setName(form.getName());
//		catDes.setDescription(form.getDescription());
//		catDes.setSefUrl(form.getSefUrl());
//		catDescs.add(catDes);
//		category.setDescriptions(catDescs);
//		category.setCode(form.getCode());
//		return category;
//	}
}
