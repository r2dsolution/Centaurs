package com.r2dsolution.comein.centaurs.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserKYC  implements Serializable{
			
		 
	private static final long serialVersionUID = 1L;
	//private Long id;
	
	private String firstname;
	private String lastname;
	private String email;
	private String cognitoSub;
	private String refId;
	private String refType;
	private String displayName;
	
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCognitoSub() {
		return cognitoSub;
	}
	public void setCognitoSub(String cognitoSub) {
		this.cognitoSub = cognitoSub;
	}
	@JsonProperty("ref-id")
	public String getRefId() {
		return refId;
	}
	
	public void setRefId(String refId) {
		this.refId = refId;
	}
	@JsonProperty("ref-type")
	public String getRefType() {
		return refType;
	}
	public void setRefType(String refType) {
		this.refType = refType;
	}
	@JsonProperty("display-name")
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	
}
