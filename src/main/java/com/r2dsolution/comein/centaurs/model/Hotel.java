package com.r2dsolution.comein.centaurs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hotel {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String shortName;
	private String address;
	private String country;
	private String province;
	private String image1Url;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@JsonProperty("image1-url")
	public String getImage1Url() {
		return image1Url;
	}
	public void setImage1Url(String image1Url) {
		this.image1Url = image1Url;
	}
	
}
