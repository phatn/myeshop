package com.myeshop.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "ES_CUSTOMER")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CUSTOMER_ID")
	@TableGenerator(name = "TABLE_GENERATOR", table = "ES_ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "CUSTOMER_ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GENERATOR")
	private Long id;
	
	@Column(name = "GENDER")
	@Enumerated(value = EnumType.STRING)
	private Gender gender;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CUSTOMER_DOB")
	private Date dateOfBirth;
	
	@Column(name = "CUSTOMER_EMAIL_ADDRESS")
	private String emailAddress;
	
	@Column(name = "CUSTOMER_USER_NAME")
	private String userName;
	
	@Column(name = "CUSTOMER_COMPANY")
	private String company;
	
	@Column(name = "CUSTOMER_PASSWORD")
	private String password;
	
	@Column(name="CUSTOMER_ANONYMOUS")
	private boolean anonymous;
	
	@Column(name="CUSTOMER_ENABLE")
	private boolean enable;
	
	@Embedded
	private Delivery delivery;
	
	@Embedded
	private Billing billing;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name="ES_CUSTOMER_ROLE",
	joinColumns = {@JoinColumn(name="CUSTOMER_ID")},
	inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
	private Set<Role> roles = new HashSet<Role>();
	
	@Column(name="CUSTOMER_FIRST_NAME")
	private String firstName;
	
	@Column(name="CUSTOMER_LAST_NAME")
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getAnonymous() {
		return anonymous;
	}

	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	public boolean getEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	@Transient
	public String getFullName() {
		return firstName + " " + lastName;
	}
}
