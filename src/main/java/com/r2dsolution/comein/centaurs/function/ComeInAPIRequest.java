package com.r2dsolution.comein.centaurs.function;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;




public class ComeInAPIRequest extends APIGatewayProxyRequestEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String,Object> jsonBody = new HashMap<String,Object>();
	
	private String heartbeat;

	
	public Map<String, Object> getJsonBody() {
		return jsonBody;
	}

	public void setJsonBody(Map<String, Object> jsonBody) {
		this.jsonBody = jsonBody;
	}

	private UserProfile profile;

	public UserProfile getProfile() {
		return profile;
	}

	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}
	
	public <T extends Object> T toQuery(String key,Class<T> clazz) {
		return (T)getQueryStringParameters().get(key);
	}
	
	public String toQueryStr(String key) {
		return toQuery(key,String.class);
	}

	public String getHeartbeat() {
		return heartbeat;
	}

	public void setHeartbeat(String heartbeat) {
		this.heartbeat = heartbeat;
	}
	
}
