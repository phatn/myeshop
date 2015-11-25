package com.myeshop.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


/**
 * 
 * @author Phat Nguyen
 * 
 */

@Entity
@Table(name = "ES_PRODUCT_ATTRIBUTE_VALUE")
public class ProductAttributeValue implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PRODUCT_ATTRIBUTE_VALUE_ID")
	@TableGenerator(name = "TABLE_GENERATOR", table = "ES_ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "PRODUCT_ATTRIBUTE_VALUE_ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GENERATOR")
	private Long id;
	
	@Column(name = "VALUE")
	private String value;
	
	@ManyToOne
	@JoinColumn(name = "ATTRIBUTE_ID")
	private Attribute attribute;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
}
