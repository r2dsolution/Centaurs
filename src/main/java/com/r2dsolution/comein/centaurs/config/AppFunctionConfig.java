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
import com.amazonaws.services.lambda.runtime.events.CognitoUserPoolPreSignUpEvent;
import com.r2dsolution.comein.centaurs.function.ComeInAPIRequest;
import com.r2dsolution.comein.centaurs.function.ComeInAPIResponse;
import com.r2dsolution.comein.centaurs.function.IFunction;
import com.r2dsolution.comein.centaurs.function.api.DeleteHotelBookingKYCFunc;
import com.r2dsolution.comein.centaurs.function.api.ListHotelBookingByEmailFunc;
import com.r2dsolution.comein.centaurs.function.api.ListTourBookingByEmailFunc;
import com.r2dsolution.comein.centaurs.function.api.ListTourTicketByDateFunc;
import com.r2dsolution.comein.centaurs.function.api.ReserveTourTicketFunc;
import com.r2dsolution.comein.centaurs.function.api.ViewHotelBookingByBookNOFunc;
import com.r2dsolution.comein.centaurs.function.api.ViewTourTicketByTourIdFunc;
import com.r2dsolution.comein.centaurs.function.cognito.SignUpPrePDPAInfoFunc;
import com.r2dsolution.comein.centaurs.function.api.ViewTourBookingByCodeFunc;
import com.r2dsolution.comein.centaurs.function.api.AddHotelBookingKYCFunc;
import com.r2dsolution.comein.centaurs.function.api.AddKYCInfoFunc;

@Configuration
@ComponentScan({"com.r2dsolution.comein.centaurs.function","com.r2dsolution.comein.centaurs.business","com.r2dsolution.comein.centaurs.client"})
@EnableJpaRepositories(basePackages = "com.r2dsolution.comein.centaurs.repository")
public class AppFunctionConfig {
	
	@Autowired
	ListHotelBookingByEmailFunc listHotelBookingByEmailFunc;
	
	
	@Autowired
	ListTourBookingByEmailFunc listTourBookingByEmailFunc;
	
	@Autowired
	ViewHotelBookingByBookNOFunc viewHotelBookingByBookNOFunc;
	
	@Autowired
	DeleteHotelBookingKYCFunc deleteHotelBookingKYCFunc;
	
	@Autowired
	ListTourTicketByDateFunc listTourTicketByDateFunc;
	
	@Autowired
	ViewTourTicketByTourIdFunc viewTourTicketByTourIdFunc;
	
	@Autowired
	ReserveTourTicketFunc reserveTourTicketFunc;
	
	@Autowired
	ViewTourBookingByCodeFunc viewTourBookingByCodeFunc;
	
	@Autowired
	AddHotelBookingKYCFunc addHotelBookingKYCFunc;
	
	@Autowired
	AddKYCInfoFunc addKYCInfoFunc;
	
	@Autowired
	SignUpPrePDPAInfoFunc signUpPrePDPAInfoFunc;
	
	@Bean
	public Function<CognitoUserPoolPreSignUpEvent, CognitoUserPoolPreSignUpEvent> cognitoSignUpPrePDPAInfo() throws Exception{
		System.out.println("init....................cognitoSignUpPrePDPAInfo");
		return request -> {
			return signUpPrePDPAInfoFunc.execute(request);
		};
			
	}
	
	@Bean
	public Function<ComeInAPIRequest, ComeInAPIResponse> postAddKYCInfo() throws Exception{
		System.out.println("init....................addKYCInfo");
		return request ->  doExecute(addKYCInfoFunc,request );
			
	}
	
	@Bean
	public Function<ComeInAPIRequest, ComeInAPIResponse> postAddHotelBookingKYC() throws Exception{
		System.out.println("init....................addHotelBookingKYC");
		return request ->  doExecute(addHotelBookingKYCFunc,request );
			
	}
	
	@Bean
	public Function<ComeInAPIRequest, ComeInAPIResponse> postViewTourBookingByCode() throws Exception{
		System.out.println("init....................viewTourBookingByCode");
		return request ->  doExecute(viewTourBookingByCodeFunc,request );
			
	}
	
	@Bean
	public Function<ComeInAPIRequest, ComeInAPIResponse> postReserveTourTicket() throws Exception{
		System.out.println("init....................reserveTourTicket");
		return request ->  doExecute(reserveTourTicketFunc,request );
			
	}
	
	@Bean
	public Function<ComeInAPIRequest, ComeInAPIResponse> postViewTourTicketByTourId() throws Exception{
		System.out.println("init....................viewTourTicketByTourId");
		return request ->  doExecute(viewTourTicketByTourIdFunc,request );
			
	}
	
	@Bean
	public Function<ComeInAPIRequest, ComeInAPIResponse> postListTourTicketByDate() throws Exception{
		System.out.println("init....................listTourTicketByDate");
		return request ->  doExecute(listTourTicketByDateFunc,request );
			
	}
	
	@Bean
	public Function<ComeInAPIRequest, ComeInAPIResponse> postDeleteHotelBookingKYC() throws Exception{
		System.out.println("init....................deleteHotelBookingKYC");
		return request ->  doExecute(deleteHotelBookingKYCFunc,request );
			
	}
	
	@Bean
	public Function<ComeInAPIRequest, ComeInAPIResponse> postListTourBookingByEmail() throws Exception{
		System.out.println("init....................listTourBookingByEmail");
		return request ->  doExecute(listTourBookingByEmailFunc,request );
			
	}
	
	@Bean
	public Function<ComeInAPIRequest, ComeInAPIResponse> postViewHotelBookingByBookNO() throws Exception{
		System.out.println("init....................viewHotelBookingByBookNO");
		return request ->  doExecute(viewHotelBookingByBookNOFunc,request );
			
	}
	
	@Bean
	public Function<ComeInAPIRequest, ComeInAPIResponse> postListBookingByEmail() throws Exception{
		System.out.println("init....................listBookingByEmail");
		return request ->  doExecute(listHotelBookingByEmailFunc,request );
			
	}
	
	@Bean
	public Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> postTest(){
		System.out.println("init....................test");
		return request -> {
			APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
			response.setBody("service is up.");
			return response;
		};
		
	}
	
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
