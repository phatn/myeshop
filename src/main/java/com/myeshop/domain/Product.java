package com.myeshop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import flexjson.JSON;


/**
 * 
 * @author Phat Nguyen
 * 
 */

@Entity
@Table(name = "ES_PRODUCT")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PRODUCT_ID")
	@TableGenerator(name = "TABLE_GENERATOR", table = "ES_ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "PRODUCT_ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GENERATOR")
	private Long id;
	
	@Column(name = "SKU")
	private String sku;
	
	@Column(name = "PRODUCT_PRICE")
	private BigDecimal productPrice;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_CREATED")
	private Date dateCreated;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_MODIFIED")
	private Date dateModified;
	
	@Column(name = "AVAILABLE")
	private boolean available = true;

	@Column(name = "SORT_ORDER")
	private Integer sortOrder;
	
	@Column(name = "QUANTITY_ORDERED")
	private Integer quantityOrdered;
	
	@Column(name = "REVIEW_COUNT")
	private Integer reviewCount;
	
	@Column(name = "FEATURED_SELLER")
	private Boolean featuredSeller = false;
	
	@Column(name = "NEW_RELEASE")
	private Boolean newRelease = false;
	
	@Column(name = "CLEARANCE")
	private Boolean clearance = false;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="product")
	private Set<ProductDescription> descriptions = new HashSet<ProductDescription>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy="product")
	private Set<ProductImage> productImages = new HashSet<ProductImage>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "product")
	private Set<ProductRelationship> relationships = new HashSet<ProductRelationship>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name="ES_PRODUCT_ATTRIBUTE",
	joinColumns = {@JoinColumn(name="PRODUCT_ID")},
	inverseJoinColumns = {@JoinColumn(name = "ATTRIBUTE_ID")})
	private Set<Attribute> attributes = new HashSet<Attribute>();
	
	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name="ES_CATEGORY_PRODUCT",
	joinColumns = {@JoinColumn(name="PRODUCT_ID")},
	inverseJoinColumns = {@JoinColumn(name = "CATEGORY_ID")})
	private Set<Category> categories = new HashSet<Category>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	
	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public Integer getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public Set<ProductDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<ProductDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public Set<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(Set<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public Set<ProductRelationship> getRelationships() {
		return relationships;
	}

	public void setRelationships(Set<ProductRelationship> relationships) {
		this.relationships = relationships;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public Set<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(Set<Attribute> attributes) {
		this.attributes = attributes;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}


	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@JSON(include = false)
	public Attribute getAttribute() {
		if(getAttributes() != null) {
			Iterator<Attribute> it = getAttributes().iterator();
			return it.next();
		}
		return null;
	}
	
	public Attribute getAttributeName() {
		if(getAttributes() != null) {
			for(Attribute attribute : getAttributes()) {
				if("Name".equalsIgnoreCase(attribute.getName())) {
					return attribute;
				}
			}
		}
		return null;
	}
	
	public ProductImage getSmallImage() {
		if(getProductImages() != null) {
			for(ProductImage image : getProductImages()) {
				if(image.getImageSize() == ImageSize.SMALL) {
					return image;
				}
			}
		}
		return null;
	}
	
	@JSON(include = false)
	public List<ProductImage> getTinyImages() {
		List<ProductImage> tinyImages = new ArrayList<ProductImage>();
		if(getProductImages() != null) {
			for(ProductImage image : getProductImages()) {
				if(image.getImageSize() == ImageSize.TINY) {
					tinyImages.add(image);
				}
			}
		}
		return tinyImages;
	}
	
	@JSON(include = false)
	public List<ProductImage> getMediumImages() {
		List<ProductImage> mediumImages = new ArrayList<ProductImage>();
		if(getProductImages() != null) {
			for(ProductImage image : getProductImages()) {
				if(image.getImageSize() == ImageSize.MEDIUM) {
					mediumImages.add(image);
				}
			}
		}
		return mediumImages;
	}
	
	@JSON(include = false)
	public List<ProductImage> getBigImages() {
		List<ProductImage> bigImages = new ArrayList<ProductImage>();
		if(getProductImages() != null) {
			for(ProductImage image : getProductImages()) {
				if(image.getImageSize() == ImageSize.BIG) {
					bigImages.add(image);
				}
			}
		}
		return bigImages;
	}
}
