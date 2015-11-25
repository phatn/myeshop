package com.myeshop.domain;

import java.io.Serializable;
import java.util.HashSet;
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
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Entity
@Table(name = "ES_ROLE")
public class Role implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ROLE_ID")
	@TableGenerator(name = "TABLE_GENERATOR", table = "ES_ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "ROLE_ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GENERATOR")
	private Long id;
	
	@Column(name = "NAME")
	private String name;

	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<User>();
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private Set<Customer> customers = new HashSet<Customer>();
	
	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name="ES_ROLE_PERMISSION",
	joinColumns = {@JoinColumn(name="ROLE_ID")},
	inverseJoinColumns = {@JoinColumn(name = "PERMISSION_ID")})
	private Set<Permission> permissions = new HashSet<Permission>();
	
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
}
