package com.myeshop.web.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.myeshop.domain.Attribute;
import com.myeshop.domain.Category;
import com.myeshop.domain.ProductDescription;
import com.myeshop.domain.ProductImage;
import com.myeshop.domain.ProductRelationship;


public class ProductForm {
	
	private Long id;
	
	private String name;
	
	private String sku;
	
	private BigDecimal productPrice;
	
	private boolean available;
	
	private Boolean featuredSeller;
	
	private Boolean newRelease;
	
	private Boolean clearance;
	
	private Boolean deleted;
	
//	private Set<ProductDescription> descriptions = new HashSet<ProductDescription>();
//	
//	private Set<ProductImage> productImages = new HashSet<ProductImage>();
//	
//	private Set<ProductRelationship> relationships = new HashSet<ProductRelationship>();
//	
//	private Set<Attribute> attributes = new HashSet<Attribute>();
//	
//	private Set<Category> categories = new HashSet<Category>();

	private String image;
	
	private MultipartFile multipartFileImage;
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public MultipartFile getMultipartFileImage() {
		return multipartFileImage;
	}

	public void setMultipartFileImage(MultipartFile multipartFileImage) {
		this.multipartFileImage = multipartFileImage;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Boolean getFeaturedSeller() {
		return featuredSeller;
	}

	public void setFeaturedSeller(Boolean featuredSeller) {
		this.featuredSeller = featuredSeller;
	}

	public Boolean getNewRelease() {
		return newRelease;
	}

	public void setNewRelease(Boolean newRelease) {
		this.newRelease = newRelease;
	}

	public Boolean getClearance() {
		return clearance;
	}

	public void setClearance(Boolean clearance) {
		this.clearance = clearance;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

//	public Set<ProductDescription> getDescriptions() {
//		return descriptions;
//	}
//
//	public void setDescriptions(Set<ProductDescription> descriptions) {
//		this.descriptions = descriptions;
//	}
//
//	public Set<ProductImage> getProductImages() {
//		return productImages;
//	}
//
//	public void setProductImages(Set<ProductImage> productImages) {
//		this.productImages = productImages;
//	}
//
//	public Set<ProductRelationship> getRelationships() {
//		return relationships;
//	}
//
//	public void setRelationships(Set<ProductRelationship> relationships) {
//		this.relationships = relationships;
//	}
//
//	public Set<Attribute> getAttributes() {
//		return attributes;
//	}
//
//	public void setAttributes(Set<Attribute> attributes) {
//		this.attributes = attributes;
//	}
//
//	public Set<Category> getCategories() {
//		return categories;
//	}
//
//	public void setCategories(Set<Category> categories) {
//		this.categories = categories;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
