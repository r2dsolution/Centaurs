package com.r2dsolution.comein.centaurs.function;

import java.util.HashMap;
import java.util.Map;


import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ComeInAPIResponse extends APIGatewayProxyResponseEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String,Object> jsonBody = new HashMap<String,Object>();
	

	public ComeInAPIResponse() {
		super();
	}

	@JsonProperty("json-body")
	public Map<String, Object> getJsonBody() {
		return jsonBody;
	}

	public void setJsonBody(Map<String, Object> jsonBody) {
		this.jsonBody = jsonBody;
	}

	

	
	

}
