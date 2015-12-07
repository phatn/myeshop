package com.myeshop.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myeshop.domain.Language;
import com.myeshop.domain.Product;
import com.myeshop.service.ProductService;
import com.myeshop.web.contants.Constant;
import com.myeshop.web.entity.ProductForm;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {
	
	private static Logger logger = Logger.getLogger(AdminProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/edit/{productId}", method = RequestMethod.GET)
	public String add(Model model, @PathVariable("productId") Long productId) {
		Product product = productService.getById(productId);
		ProductForm productForm = toProductForm(product);
		model.addAttribute("product", productForm);
		return "editProduct";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	String editSubmit(@ModelAttribute("product") @Valid ProductForm form, 
		BindingResult result, HttpServletRequest request, RedirectAttributes redir) {
	
		if(result.hasErrors()) {
			return "editProduct";
		}
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		MultipartFile multipartFileImage = form.getMultipartFileImage();
		if(multipartFileImage != null && !multipartFileImage.isEmpty()) {
			String filePath = rootDirectory + "resources" + Constant.FILE_SEPERATOR + "images" + Constant.FILE_SEPERATOR  +"uploads" + Constant.FILE_SEPERATOR + "products" + Constant.FILE_SEPERATOR + form.getId() + ".png";
			logger.info("Path to upload image: " + filePath);
			try {
				multipartFileImage.transferTo(new File(filePath));
			} catch(Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}
		Language language = (Language)request.getAttribute(Constant.LANGUAGE);
		Product product = productService.getById(form.getId());
		
		redir.addFlashAttribute("message", "Update " + form.getName() + " product successfully.");
		//return "redirect:/admin/category/listProducts/" + categoryId;
		return "redirect:/admin/category/list";
	}
	
	@RequestMapping(value = "/delete/{productId}", method = RequestMethod.POST)
	public String delete(@PathVariable("productId") Long productId, @RequestParam("categoryId") Long categoryId, RedirectAttributes redir) {
		productService.deleteById(productId);
		redir.addFlashAttribute("message", "Delete successfully.");
		return "redirect:/admin/category/listProducts/" + categoryId;
	}
	
	private ProductForm toProductForm(Product product) {
		ProductForm form = new ProductForm();
		form.setId(product.getId());
		form.setName(product.getAttributeName().getAttributeValue().getValue());
		form.setImage(product.getSmallImage().getImage());
		form.setNewRelease(product.getNewRelease());
		form.setClearance(product.getClearance());
		form.setFeaturedSeller(product.getFeaturedSeller());
		return form;
	}
	
}
