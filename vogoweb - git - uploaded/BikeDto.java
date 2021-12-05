package com.vogo.dto;

import lombok.Getter;
import lombok.Setter;

public class BikeDto {
	private int bikeNo;
	private String bikeModelName;
	private String manufacturer;
	private double price;

	public int getBikeNo() {
		return bikeNo;
	}

	public void setBikeNo(int bikeNo) {
		this.bikeNo = bikeNo;
	}

	public String getBikeModelName() {
		return bikeModelName;
	}

	public void setBikeModelName(String bikeModelName) {
		this.bikeModelName = bikeModelName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
