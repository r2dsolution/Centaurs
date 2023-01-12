package com.r2dsolution.comein.centaurs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelBooking implements Serializable{
	
	 
	private static final long serialVersionUID = 1L;
	private Long id;
	private String bookNO;
	// private String customer;
	 private String refName;
	 private String refName2;
	 private Hotel hotel;
	 private long visitorAdult;
	 private long visitorChild;
	 private String checkIn;
	 private String checkOut;
	 private String roomName;
	 private String roomDesc;
	// private String customerEmail;
	 
	 private Map<String,UserKYC> kycInfo = new HashMap<String,UserKYC>();
	 
	 private List<String> kycEmail = new ArrayList<String>();
	 private List<String> cardId = new ArrayList<String>();
	 
	@JsonProperty("book-no")
	public String getBookNO() {
		return bookNO;
	}
	public void setBookNO(String bookNO) {
		this.bookNO = bookNO;
	}
//	public String getCustomer() {
//		return customer;
//	}
//	public void setCustomer(String customer) {
//		this.customer = customer;
//	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	@JsonProperty("check-in")
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	
	@JsonProperty("check-out")
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	
	@JsonProperty("room-name")
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	@JsonProperty("room-desc")
	public String getRoomDesc() {
		return roomDesc;
	}
	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}
	@JsonProperty("visitor-adult")
	public long getVisitorAdult() {
		return visitorAdult;
	}
	public void setVisitorAdult(long visitorAdult) {
		this.visitorAdult = visitorAdult;
	}
	@JsonProperty("visitor-child")
	public long getVisitorChild() {
		return visitorChild;
	}
	public void setVisitorChild(long visitorChild) {
		this.visitorChild = visitorChild;
	}
	
//	@JsonProperty("customer-email")
//	public String getCustomerEmail() {
//		return customerEmail;
//	}
//	public void setCustomerEmail(String customerEmail) {
//		this.customerEmail = customerEmail;
//	}
	
	@JsonProperty("kyc-info")
	public Map<String, UserKYC> getKycInfo() {
		return kycInfo;
	}
	public void setKycInfo(Map<String, UserKYC> kycInfo) {
		this.kycInfo = kycInfo;
	}
	@JsonProperty("kyc-email")
	public List<String> getKycEmail() {
		return kycEmail;
	}
	public void setKycEmail(List<String> kycEmail) {
		this.kycEmail = kycEmail;
	}
	@JsonProperty("card-id")
	public List<String> getCardId() {
		return cardId;
	}
	public void setCardId(List<String> cardId) {
		this.cardId = cardId;
	}
	@JsonProperty("ref-name")
	public String getRefName() {
		return refName;
	}
	public void setRefName(String refName) {
		this.refName = refName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@JsonProperty("ref-name2")
	public String getRefName2() {
		return refName2;
	}
	public void setRefName2(String refName2) {
		this.refName2 = refName2;
	}
	
	 
	 
	 

}
