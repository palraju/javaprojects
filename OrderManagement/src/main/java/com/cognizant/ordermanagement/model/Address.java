package com.cognizant.ordermanagement.model;

import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.Frozen;
import com.datastax.driver.mapping.annotations.UDT;


@UDT(name = "address" ,keyspace="order_mgmt_db")
public class Address {

	@Field(name="street")
	private String street;
	@Field(name="city")
	private String city;
	@Field(name="state")
	private String state;
	@Field(name="zip")
	private String zip;
	@Field(name="country")
	private String country;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
