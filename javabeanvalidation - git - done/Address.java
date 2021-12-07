package com.jbv.bean;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Address {
	@NotBlank(message = "houseAddress cannot be blank")
	private String houseAddress;
	@NotBlank(message = "streetAddress cannot be blank")
	private String streetAddress;
	@NotBlank(message = "city cannot be blank")
	private String city;
	@NotBlank(message = "state cannot be blank")
	@Length(min = 2, max = 4, message = "state should be between 2 to 4 characters in length")
	private String state;
	@Min(value = 10000, message = "zip code should be minimum of 10000")
	@Max(value = 99999, message = "zip code should be maximum of 99999")
	private int zip;
	@NotBlank(message = "country cannot be blank")
	private String country;

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
