package com.r2dsolution.comein.centaurs.model;

import java.io.Serializable;
import java.math.BigDecimal;



import com.fasterxml.jackson.annotation.JsonProperty;

public class TourTicket  implements Serializable{
	
	 
	private static final long serialVersionUID = 1L;
	
	private String code;

	private Long tourId;
	
	private Long inventoryId;
	
	private String tourDate;
	
	private Long total;
	
	private Long ticketCount;
	
	private Long firstTicketId;
	
	private Long companyId;
	
	private String companyName;
	
	private String companyAddress;
	
	private String tourName;
	
	private String tourDesc;
	
	private String startDate;
	
	private String endDate;
	
	private String tourStatus;
	
	private String country;
	
	private String province;
	
	private String detail;
	
	private String ticketCode;
	
	private BigDecimal adultRate;
	
	private BigDecimal childRate;
	
	private String cancelable;
	private Integer cancelBefore;
	private String ticketStatus;
	
	@JsonProperty("tour-id")
	public Long getTourId() {
		return tourId;
	}
	public void setTourId(Long tourId) {
		this.tourId = tourId;
	}
	
	@JsonProperty("inventory-id")
	public Long getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}
	
	@JsonProperty("tour-date")
	public String getTourDate() {
		return tourDate;
	}
	public void setTourDate(String tourDate) {
		this.tourDate = tourDate;
	}
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	@JsonProperty("ticket-count")
	public Long getTicketCount() {
		return ticketCount;
	}
	public void setTicketCount(Long ticketCount) {
		this.ticketCount = ticketCount;
	}
	
	@JsonProperty("first-ticket-id")
	public Long getFirstTicketId() {
		return firstTicketId;
	}
	public void setFirstTicketId(Long firstTicketId) {
		this.firstTicketId = firstTicketId;
	}
	
	@JsonProperty("company-id")
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
	@JsonProperty("tour-name")
	public String getTourName() {
		return tourName;
	}
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	
	@JsonProperty("tour-desc")
	public String getTourDesc() {
		return tourDesc;
	}
	public void setTourDesc(String tourDesc) {
		this.tourDesc = tourDesc;
	}
	
	@JsonProperty("start-date")
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	@JsonProperty("end-date")
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	@JsonProperty("tour-status")
	public String getTourStatus() {
		return tourStatus;
	}
	public void setTourStatus(String tourStatus) {
		this.tourStatus = tourStatus;
	}
	
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
	
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	@JsonProperty("ticket-code")
	public String getTicketCode() {
		return ticketCode;
	}
	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}
	
	@JsonProperty("adult-rate")
	public BigDecimal getAdultRate() {
		return adultRate;
	}
	public void setAdultRate(BigDecimal adultRate) {
		this.adultRate = adultRate;
	}
	
	@JsonProperty("child-rate")
	public BigDecimal getChildRate() {
		return childRate;
	}
	public void setChildRate(BigDecimal childRate) {
		this.childRate = childRate;
	}
	
	@JsonProperty("cancellable")
	public String getCancelable() {
		return cancelable;
	}
	public void setCancelable(String cancelable) {
		this.cancelable = cancelable;
	}
	
	@JsonProperty("cancel-before")
	public Integer getCancelBefore() {
		return cancelBefore;
	}
	public void setCancelBefore(Integer cancelBefore) {
		this.cancelBefore = cancelBefore;
	}
	
	@JsonProperty("ticket-status")
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	
	@JsonProperty("company-name")
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@JsonProperty("company-address")
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	

}
