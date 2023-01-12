package com.r2dsolution.comein.centaurs.model;

import java.io.Serializable;

public class TourBookingRequest implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int tourId;
	private String tourDate ;
	private String location;
	private int adult;
	private int child;
	private String remark;
	
	private String ownerId;
	private String refName;
	
	private String bookingCode;
	
	public int getTourId() {
		return tourId;
	}
	public void setTourId(int tourId) {
		this.tourId = tourId;
	}
	public String getTourDate() {
		return tourDate;
	}
	public void setTourDate(String tourDate) {
		this.tourDate = tourDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getAdult() {
		return adult;
	}
	public void setAdult(int adult) {
		this.adult = adult;
	}
	public int getChild() {
		return child;
	}
	public void setChild(int child) {
		this.child = child;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getRefName() {
		return refName;
	}
	public void setRefName(String refName) {
		this.refName = refName;
	}
	public String getBookingCode() {
		return bookingCode;
	}
	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}
	
	

}
