package com.r2dsolution.comein.centaurs.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity(name="booking_kyc")
public class BookingKYCInfoM  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "booking_kyc_id_seq"),
        @Parameter(name = "initial_value", value = "10"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private Long id;
	
	private Long userKycId;
	
//	private String firstname;
//	private String lastname;
//	private String fullname;
//	private String email;
	private String refId;
	private String refType;
	
	@ManyToOne
	@JoinColumn(name = "booking_id")
	private BookingInfoM bookingInfo;
	
	//AggregateReference<BookingInfoM, Long> bookingId;
	
	
	
	public BookingKYCInfoM() {
		super();
		
	}
	public BookingKYCInfoM(UserKYCInfoM user) {
		super();
		this.userKycId = user.getId();
//		this.firstname = user.getFirstname();
//		this.lastname = user.getLastname();
//		this.fullname = user.getFirstname()+" "+user.getLastname();
//		this.email = user.getEmail();
		this.refId = user.getRefId();
		this.refType = user.getRefType();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
//	public String getFirstname() {
//		return firstname;
//	}
//	public void setFirstname(String firstname) {
//		this.firstname = firstname;
//	}
//	public String getLastname() {
//		return lastname;
//	}
//	public void setLastname(String lastname) {
//		this.lastname = lastname;
//	}
//	public String getFullname() {
//		return fullname;
//	}
//	public void setFullname(String fullname) {
//		this.fullname = fullname;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	public String getRefType() {
		return refType;
	}
	public void setRefType(String refType) {
		this.refType = refType;
	}
//	public AggregateReference<BookingInfoM, Long> getBookingId() {
//		return bookingId;
//	}
//	public void setBookingId(AggregateReference<BookingInfoM, Long> bookingId) {
//		this.bookingId = bookingId;
//	}
	
	public Long getUserKycId() {
		return userKycId;
	}
	public void setUserKycId(Long userKycId) {
		this.userKycId = userKycId;
	}
	public BookingInfoM getBookingInfo() {
		return bookingInfo;
	}
	public void setBookingInfo(BookingInfoM bookingInfo) {
		this.bookingInfo = bookingInfo;
	}
	
	

}
