package com.r2dsolution.comein.centaurs.model;

import java.util.HashMap;
import java.util.Map;

public class EmailRequest {
	private String template;
	private String email;
	private Map<String,String> params= new HashMap<String,String>();
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Map<String, String> getParams() {
		return params;
	}
	public void setParams(Map<String, String> params) {
		this.params = params;
	}
	
	

}