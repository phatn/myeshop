package com.myeshop.domain;

import java.io.Serializable;
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
@Table(name = "es_attribute")
public class Attribute implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "attribute_id")
	@TableGenerator(name = "table_generator", table = "es_id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", pkColumnValue = "attribute_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator="table_generator")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_created")
	private Date dateCreated;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_modified")
	private Date dateModified;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "attribute")
	private Set<ProductAttributeValue> attributeValues = new HashSet<ProductAttributeValue>();
	
	
	@ManyToMany(mappedBy = "attributes")
	@JSON(include = false)
	private List<Product> products = new ArrayList<Product>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Set<ProductAttributeValue> getAttributeValues() {
		return attributeValues;
	}

	public void setAttributeValues(Set<ProductAttributeValue> attributeValues) {
		this.attributeValues = attributeValues;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public ProductAttributeValue getAttributeValue() {
		if(getAttributeValues() != null) {
			Iterator<ProductAttributeValue> it = getAttributeValues().iterator();
			return it.next();
		}
		return null;
	}
}
