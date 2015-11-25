package com.myeshop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Embeddable
public class Billing {
	
	@Column(name = "BILLING_FIRST_NAME")
	private String firstName;
	
	@Column(name = "BILLING_LAST_NAME")
	private String lastName;
	
	@Column(name = "BILLING_COMPANY")
	private String company;
	
	@Column(name = "BILLING_ADDRESS")
	private String address;
	
	@Column(name = "BILLING_STREET_ADDRESS")
	private String companyAddress;
	
	@Column(name = "BILLING_CITY")
	private String city;
	
	@Column(name = "BILLING")
	private String phone;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DBILLING_COUNTRY_ID")
	private Country country;

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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
