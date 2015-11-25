package com.myeshop.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * 
 * @author Phat Nguyen
 * 
 */

@Entity
@Table(name = "ES_PERMISSION")
public class Permission implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PERMISSION_ID")
	@TableGenerator(name = "TABLE_GENERATOR", table = "ES_ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "PERMISSION_ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GENERATOR")
	private Long id;
	
	@Column(name = "NAME")
	private String name;

	@ManyToMany(mappedBy = "permissions")
	private Set<Role> roles = new HashSet<Role>();
	
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
