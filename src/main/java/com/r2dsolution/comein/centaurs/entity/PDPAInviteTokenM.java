package com.r2dsolution.comein.centaurs.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.Id;


@Entity(name="pdpa_invite_token")
public class PDPAInviteTokenM implements Serializable{

	
	private static final long serialVersionUID = 1L;

	public static final String STATUS_EXPIRED = "EXPIRED";
	
	public static final String STATUS_ACTIVE = "ACTIVE";
	

	@Id
	@GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "pdpa_invite_token_id_seq"),
        @Parameter(name = "initial_value", value = "10"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private Long id;
	
	private String token;
	private String secretCode;
	private Timestamp expireDate ;
	private String comeinId;
	private int maxUsed;
	private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSecretCode() {
		return secretCode;
	}
	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}
	public Timestamp getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Timestamp expireDate) {
		this.expireDate = expireDate;
	}
	
	public int getMaxUsed() {
		return maxUsed;
	}
	public void setMaxUsed(int maxUsed) {
		this.maxUsed = maxUsed;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComeinId() {
		return comeinId;
	}
	public void setComeinId(String comeinId) {
		this.comeinId = comeinId;
	}
	
	

}
