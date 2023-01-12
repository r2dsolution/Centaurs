package com.r2dsolution.comein.centaurs.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookedTourTicket extends TourTicket{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ownerId;
	private String referenceName;
	private String bookingStatus;
	private int adult;
	private int child;
	private String bookingDate;
	private String expireDate;
	private String gatewayRef;
	
	private String gateway;
	private String paymentNO;
	private String paymentDate;
	private String paymentStatus;
	private BigDecimal paymentAmt;
	private Long paymentId;
	
	@JsonProperty("owner-id")
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	@JsonProperty("reference-name")
	public String getReferenceName() {
		return referenceName;
	}
	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}
	@JsonProperty("booking-status")
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
	@JsonProperty("booking-date")
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	@JsonProperty("expire-date")
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	@JsonProperty("gateway-ref")
	public String getGatewayRef() {
		return gatewayRef;
	}
	public void setGatewayRef(String gatewayRef) {
		this.gatewayRef = gatewayRef;
	}
	
	@JsonProperty("gateway")
	public String getGateway() {
		return gateway;
	}
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}
	
	@JsonProperty("payment-no")
	public String getPaymentNO() {
		return paymentNO;
	}
	public void setPaymentNO(String paymentNO) {
		this.paymentNO = paymentNO;
	}
	
	@JsonProperty("payment-date")
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	@JsonProperty("payment-status")
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	@JsonProperty("payment-amt")
	public BigDecimal getPaymentAmt() {
		return paymentAmt;
	}
	public void setPaymentAmt(BigDecimal paymentAmt) {
		this.paymentAmt = paymentAmt;
	}
	
	@JsonProperty("payment-id")
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	
	

}
