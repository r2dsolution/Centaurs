package com.r2dsolution.comein.centaurs.entity.view;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;





@Entity(name="v_ticket")
public class TourTicketView implements Serializable,TicketView{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	private Long tourId;
	
	private Long inventoryId;
	
	private java.sql.Date tourDate;
	
	private Long total;
	
	private Long ticketCount;
	
	private Long firstTicketId;
	
	private Long companyId;
	
	private String companyName;
	
	private String companyAddress;
	
	private String tourName;
	
	private String tourDesc;
	
	private java.sql.Date startDate;
	
	private java.sql.Date endDate;
	
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
	
	public Long getTourId() {
		return tourId;
	}
	public void setTourId(Long tourId) {
		this.tourId = tourId;
	}
	public Long getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}
	public java.sql.Date getTourDate() {
		return tourDate;
	}
	public void setTourDate(java.sql.Date tourDate) {
		this.tourDate = tourDate;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Long getTicketCount() {
		return ticketCount;
	}
	public void setTicketCount(Long ticketCount) {
		this.ticketCount = ticketCount;
	}
	public Long getFirstTicketId() {
		return firstTicketId;
	}
	public void setFirstTicketId(Long firstTicketId) {
		this.firstTicketId = firstTicketId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getTourName() {
		return tourName;
	}
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	public String getTourDesc() {
		return tourDesc;
	}
	public void setTourDesc(String tourDesc) {
		this.tourDesc = tourDesc;
	}
	public java.sql.Date getStartDate() {
		return startDate;
	}
	public void setStartDate(java.sql.Date startDate) {
		this.startDate = startDate;
	}
	public java.sql.Date getEndDate() {
		return endDate;
	}
	public void setEndDate(java.sql.Date endDate) {
		this.endDate = endDate;
	}
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
	public String getTicketCode() {
		return ticketCode;
	}
	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}
	public BigDecimal getAdultRate() {
		return adultRate;
	}
	public void setAdultRate(BigDecimal adultRate) {
		this.adultRate = adultRate;
	}
	public BigDecimal getChildRate() {
		return childRate;
	}
	public void setChildRate(BigDecimal childRate) {
		this.childRate = childRate;
	}
	public String getCancelable() {
		return cancelable;
	}
	public void setCancelable(String cancelable) {
		this.cancelable = cancelable;
	}
	public Integer getCancelBefore() {
		return cancelBefore;
	}
	public void setCancelBefore(Integer cancelBefore) {
		this.cancelBefore = cancelBefore;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	
	
	
	

}
