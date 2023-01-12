package com.r2dsolution.comein.centaurs.entity.view;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity(name="v_booked_ticket")
public class BookedTourTicketView implements Serializable,TicketView{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	private Long tourId;
	private Long inventoryId;
	
	@Id
	private String code;
	
	private java.sql.Date bookingDate;
	private Date expireDate;
	
	private String bookingStatus;
	
	private String ownerId;
	
	private String referenceName;
	
	private String gatewayRef;
	
	private java.sql.Date tourDate;
	
	private Long total;
	
	private int adult;
	
	private int child;
	
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
	
	private String gateway;
	private Long paymentId;
	private String paymentNo;
	private Date paymentDate;
	private String paymentStatus;
	private BigDecimal paymentAmt;
	
	
	public Long getTourId() {
		return tourId;
	}
	public void setTourId(Long tourId) {
		this.tourId = tourId;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getReferenceName() {
		return referenceName;
	}
	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
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
	public Long getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}
	public java.sql.Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(java.sql.Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public String getGatewayRef() {
		return gatewayRef;
	}
	public void setGatewayRef(String gatewayRef) {
		this.gatewayRef = gatewayRef;
	}
	public String getGateway() {
		return gateway;
	}
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}
	
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public BigDecimal getPaymentAmt() {
		return paymentAmt;
	}
	public void setPaymentAmt(BigDecimal paymentAmt) {
		this.paymentAmt = paymentAmt;
	}
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}
	
	
	
	
	
	

}
