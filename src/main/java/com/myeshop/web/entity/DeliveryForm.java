package com.myeshop.web.entity;

import org.hibernate.validator.constraints.NotEmpty;

public class DeliveryForm {
	
	@NotEmpty(message="{NotEmpty.delivery.firstName}")
	private String firstName;
	
	@NotEmpty(message="{NotEmpty.delivery.lastName}")
	private String lastName;
	
	private String company;
	
	@NotEmpty(message="{NotEmpty.delivery.addressName}")
	private String address;
	
	private String companyAddress;
	
	private String city;
	
	private String phone;
	
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
}
