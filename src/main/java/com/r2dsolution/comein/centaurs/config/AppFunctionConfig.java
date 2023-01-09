package com.r2dsolution.comein.centaurs.config;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.r2dsolution.comein.centaurs.function.ComeInAPIRequest;
import com.r2dsolution.comein.centaurs.function.ComeInAPIResponse;
import com.r2dsolution.comein.centaurs.function.IFunction;


@Configuration
@ComponentScan({"com.r2dsolution.comein.centaurs.function","com.r2dsolution.comein.centaurs.business","com.r2dsolution.comein.centaurs.client"})
//@EnableJpaRepositories(basePackages = "com.r2dsolution.comein.centaurs.repository")
public class AppFunctionConfig {
	
	
	
	@Bean
	public Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> getHelloWorld(){
		System.out.println("init....................getHelloWorld");
		return request -> {
			APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
			response.setBody("Get event: Hello World by spring-cloud-function.");
			return response;
		};
		
	}
	
	@Bean
	public Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> postHelloWorld(){
		System.out.println("init....................postHelloWorld");
		return request -> {
			APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
			response.setBody("Post event: Hello World by spring-cloud-function.");
			return response;
		};
		
	}
	

	protected ComeInAPIResponse doExecute(IFunction func,ComeInAPIRequest request){
		try {
			return func.execute(request);
		} catch (Exception e) {
			e.printStackTrace();
			return errorExecute(e,request);
		}
	}

	protected ComeInAPIResponse errorExecute(Exception e,ComeInAPIRequest request) {
		ComeInAPIResponse response = new ComeInAPIResponse();
		response.setStatusCode(200);
		response.setBody(e.getMessage());
		Map<String,Object> json = new HashMap<String,Object>();
		json.put("error", e.getMessage());
		response.setJsonBody(json );
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Content-Type", "application/json");
		response.setHeaders(headers);
		return response;
	}
}
