package com.r2dsolution.comein.centaurs.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;




@Entity(name="booking_info")
@NamedEntityGraph(name = "BookingInfoM.kycInfo", attributeNodes = @NamedAttributeNode("kycInfo"))
public class BookingInfoM implements Serializable{

	
	private static final long serialVersionUID = 1L;
	public static final String STATUS_ACTIVE = "Active";
	public static final String STATUS_CANCEL = "Cancel";
	
	@Id
	@GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "booking_info_id_seq"),
        @Parameter(name = "initial_value", value = "10"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private Long id;
	
	private String bookingNo;
	private java.sql.Date bookingDate;
	
	
	
	//private String email;
	private String ownerId;
	private String roomName;
	private String roomDesc;
	
	private java.sql.Date checkin;
	private java.sql.Date checkout;
	
	private String refName;
	private String refName2;
	private long visitorAdult;
    private long visitorChild;
    
    private java.sql.Timestamp createdDate;
    private String createdBy;
    private String otaRefEmail;
    private String otaRefContact;
    private Long otaBookingId;
    private Long otaCancelId;
    private double price;
    
	
    private String status;
    private java.sql.Timestamp updatedDate;
    private String updatedBy;

	//AggregateReference<HotelM, Long> hotelId;
    
    @ManyToOne
	@JoinColumn(name = "hotel_id")
    private HotelM hotelInfo;
	

    @OneToMany(mappedBy = "bookingInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKey(name="refId")
	Map<String,BookingKYCInfoM> kycInfo = new HashMap<String,BookingKYCInfoM>();
	
	public void addBookingKYC(BookingKYCInfoM bookKYC) {
		bookKYC.setBookingInfo(this);
	//	bookKYC.setBookingId( AggregateReference.to(this.id));
		kycInfo.put(bookKYC.getRefId(), bookKYC);
	}
	
	public void removeBookingKYC(BookingKYCInfoM bookKYC) {
		bookKYC.setBookingInfo(null);
		this.getKycInfo().remove(bookKYC.getRefId());
	}
	public void removeBookingKYC(String refId) {
		this.getKycInfo().remove(refId);
	}

	public String getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}



	
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}

	

//	public AggregateReference<HotelM, Long> getHotelId() {
//		return hotelId;
//	}
//
//	public void setHotelId(AggregateReference<HotelM, Long> hotelId) {
//		this.hotelId = hotelId;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	

	public java.sql.Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(java.sql.Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public java.sql.Date getCheckin() {
		return checkin;
	}

	public void setCheckin(java.sql.Date checkin) {
		this.checkin = checkin;
	}

	public java.sql.Date getCheckout() {
		return checkout;
	}

	public void setCheckout(java.sql.Date checkout) {
		this.checkout = checkout;
	}

	

	public String getRefName() {
		return refName;
	}

	public void setRefName(String refName) {
		this.refName = refName;
	}

	public long getVisitorAdult() {
		return visitorAdult;
	}

	public void setVisitorAdult(long visitorAdult) {
		this.visitorAdult = visitorAdult;
	}

	public long getVisitorChild() {
		return visitorChild;
	}

	public void setVisitorChild(long visitorChild) {
		this.visitorChild = visitorChild;
	}

	public String getRefName2() {
		return refName2;
	}

	public void setRefName2(String refName2) {
		this.refName2 = refName2;
	}

	public Map<String, BookingKYCInfoM> getKycInfo() {
		return kycInfo;
	}

	public void setKycInfo(Map<String, BookingKYCInfoM> kycInfo) {
		this.kycInfo = kycInfo;
	}

	public java.sql.Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(java.sql.Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getOtaRefEmail() {
		return otaRefEmail;
	}

	public void setOtaRefEmail(String otaRefEmail) {
		this.otaRefEmail = otaRefEmail;
	}

	public Long getOtaBookingId() {
		return otaBookingId;
	}

	public void setOtaBookingId(Long otaBookingId) {
		this.otaBookingId = otaBookingId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getOtaRefContact() {
		return otaRefContact;
	}

	public void setOtaRefContact(String otaRefContact) {
		this.otaRefContact = otaRefContact;
	}

	public Long getOtaCancelId() {
		return otaCancelId;
	}

	public void setOtaCancelId(Long otaCancelId) {
		this.otaCancelId = otaCancelId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public java.sql.Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(java.sql.Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public HotelM getHotelInfo() {
		return hotelInfo;
	}

	public void setHotelInfo(HotelM hotelInfo) {
		this.hotelInfo = hotelInfo;
	}

	
	
	
	
	

}
