package com.r2dsolution.comein.centaurs.function.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sqs.AmazonSQS;
import com.r2dsolution.comein.centaurs.client.SimpleQueueServiceClient;
import com.r2dsolution.comein.centaurs.function.ComeInFunction;
import com.r2dsolution.comein.centaurs.function.ComeInAPIRequest;
import com.r2dsolution.comein.centaurs.function.ComeInAPIResponse;
import com.r2dsolution.comein.centaurs.model.TourBookingRequest;
import com.r2dsolution.comein.centaurs.util.StringUtils;



@Component
public class ReserveTourTicketFunc  extends ComeInFunction{
	
	
	@Autowired
	SimpleQueueServiceClient client;
	
	@Override
	public ComeInAPIResponse doExecute(ComeInAPIRequest request) throws Exception {
		try {
		
			Map<String,Object> input = request.getJsonBody();
			Map<String,Object> output = new HashMap<String,Object>();
			
//			SimpleQueueServiceClient client = ctx.getBean(SimpleQueueServiceClient.class);
			AmazonSQS sqsClient = client.initClient();
			String url = client.urlReserveTourBooking(sqsClient);
			
			
			 String ownerId = request.getProfile().getComeinId();
			 String ref = request.getProfile().getRefName();
			 
			 int adult = (int) input.get("adult");
			 int child = (int) input.get("child");
			 String location = (String) input.get("special-inst");
			 String remark  = "-";
			 String tourDate = (String) input.get("tour-date");
			 int tourId =  (int) input.get("tour-id");
			 
			 String bookingCode = StringUtils.randomStr(10);
			 
			 TourBookingRequest req = new TourBookingRequest();
			 req.setOwnerId(ownerId);
			 req.setRefName(ref);
			 req.setAdult(adult);
			 req.setChild(child);
			 req.setLocation(location);
			 req.setRemark(remark);
			 req.setTourDate(tourDate);
			 req.setTourId(tourId);
			 req.setBookingCode(bookingCode);
			 
			 client.sendFIFO(sqsClient, url, req,"ReserveTourBooking");
			
			output.put("book-code", bookingCode);
			
			return toComeInResults(output);
		 } catch (Exception e) {
				e.printStackTrace();
				log("error: "+e.getMessage());
				throw e;
		}
	}

}
