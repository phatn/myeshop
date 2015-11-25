package com.myeshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 *  
 * @author Phat Nguyen
 * 
 */

@Entity
@Table(name = "ES_CATEGORY")
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CATEGORY_ID")
	@TableGenerator(name = "TABLE_GENERATOR", table = "ES_ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "CATEGORY_ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GENERATOR")
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_CREATED")
	private Date dateCreated;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_MODIFIED")
	private Date dateModified;
	
	@Column(name = "CATEGORY_IMAGE")
	private String categoryImage;
	
	@Column(name = "SORT_ORDER")
	private Integer sortOrder = 0;
	
	@Column(name = "VISIBLE")
	private boolean visible;
	
	@Column(name = "DEPTH")
	private Integer depth;

	@Column(name = "LINEAGE")
	private String lineage;
	
	@Column(name= "CODE", length = 100, nullable = false)
	private String code;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	private Category parent;
	
	@OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private Set<Category> categories = new HashSet<Category>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "category")
	private Set<CategoryDescription> descriptions = new HashSet<CategoryDescription>();

	@ManyToMany(mappedBy = "categories")
	private Set<Product> products = new HashSet<Product>();
	
	@Transient
	private List<Category> subCategories = new ArrayList<Category>();
	
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

	public String getCategoryImage() {
		return categoryImage;
	}

	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<CategoryDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<CategoryDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public CategoryDescription getDescription() {
		if(descriptions != null && !descriptions.isEmpty()) {
			return descriptions.iterator().next();
		}
		return null;
	}

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public String getLineage() {
		return lineage;
	}

	public void setLineage(String lineage) {
		this.lineage = lineage;
	}

	public List<Category> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
