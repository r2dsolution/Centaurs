package com.r2dsolution.comein.centaurs.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.*;

@Entity(name="kyc_info")
public class UserKYCInfoM implements Serializable{
	
	public static String EMAIL_REF = "EMAIL";
	public static String NATIONAL_CARD_REF = "NATIONAL_CARD";
	public static String PASSPORT_CARD_REF = "PASSPORT";
	public static String COMEIN_ID_REF = "COMEIN_ID";

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "kyc_info_id_seq"),
        @Parameter(name = "initial_value", value = "10"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private Long id;
	
	private String refName;
	
//	private String title;
//	private String firstname;
//	private String lastname;
	//private String email;
	//private String targetId;
	//private String cardId;
	
//	private String cognitoSub;
//	private String language;
	//private String kycRef;
	
	private String refId;
	private String refType;
	
	//private String profile;
	private String ownerId;
//	private String refImage;
//	private String signImage;
	
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
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getCognitoSub() {
//		return cognitoSub;
//	}
//	public void setCognitoSub(String cognitoSub) {
//		this.cognitoSub = cognitoSub;
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
	
	
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getProfile() {
//		return profile;
//	}
//	public void setProfile(String profile) {
//		this.profile = profile;
//	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String str) {
		this.ownerId=str;
	}
//	public String getLanguage() {
//		return language;
//	}
//	public void setLanguage(String language) {
//		this.language = language;
//	}
//	public String getRefImage() {
//		return refImage;
//	}
//	public void setRefImage(String refImage) {
//		this.refImage = refImage;
//	}
//	public String getSignImage() {
//		return signImage;
//	}
//	public void setSignImage(String signImage) {
//		this.signImage = signImage;
//	}
//	public String getTargetId() {
//		return targetId;
//	}
//	public void setTargetId(String targetId) {
//		this.targetId = targetId;
//	}
	public String getRefName() {
		return refName;
	}
	public void setRefName(String refName) {
		this.refName = refName;
	}

	
	
	

}
