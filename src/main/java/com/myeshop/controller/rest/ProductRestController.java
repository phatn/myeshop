package com.myeshop.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myeshop.domain.Product;
import com.myeshop.domain.ProductRelationship;
import com.myeshop.service.ProductRelationshipService;
import com.myeshop.service.ProductService;

import flexjson.JSONSerializer;

@RestController
@RequestMapping("/api/product/")
public class ProductRestController {
	
	public static final String NEW_RELEASE = "newRelease";
	public static final String CLEARANCE = "clearance";
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRelationshipService productRelationshipService;
	
	@RequestMapping("specification/{productId}")
	public String getProductSpecifications(@PathVariable("productId") Long id) {
		Product product = productService.getSpecById(id);
		return new JSONSerializer().exclude("*.class").exclude("categories").
				exclude("descriptions").exclude("productImages").
				exclude("relationships").exclude("smallImage").deepSerialize(product);
	}
	
	@RequestMapping("relatedProducts/{productId}")
	public String getRelatedProducts(@PathVariable("productId") Long id) {
		List<ProductRelationship> productRelationships = productRelationshipService.getByProductId(id);
		List<Product> products = new ArrayList<>();
		for(ProductRelationship productRelationship : productRelationships) {
			Product product = new Product();
			product.setId(productRelationship.getRelatedProduct().getId());
			product.getAttributes().add(productRelationship.getRelatedProduct().getAttributeName());
			product.getProductImages().add(productRelationship.getRelatedProduct().getSmallImage());
			products.add(product);
		}
		return new JSONSerializer().exclude("*.class").serialize(products);
	}
	
	@RequestMapping("{typeProduct}")
	public String getProduct(HttpServletRequest request, 
			@PathVariable("typeProduct") String typeProduct) {
		List<Product> products = new ArrayList<>();
		if(NEW_RELEASE.equalsIgnoreCase(typeProduct)) {
			products = productService.getNewReleaseProducts();
		} else if(CLEARANCE.equalsIgnoreCase(typeProduct)) {
			products = productService.getClearanceProducts();
		}
		return new JSONSerializer().exclude("*.class").serialize(products);
	}
}
