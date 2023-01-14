package com.r2dsolution.comein.centaurs.function.api;

import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.r2dsolution.comein.centaurs.entity.view.TicketView;
import com.r2dsolution.comein.centaurs.entity.view.TourTicketView;
import com.r2dsolution.comein.centaurs.function.ComeInFunction;
import com.r2dsolution.comein.centaurs.function.IFunction;
import com.r2dsolution.comein.centaurs.function.ComeInAPIRequest;
import com.r2dsolution.comein.centaurs.function.ComeInAPIResponse;
import com.r2dsolution.comein.centaurs.model.ComeInMapper;
import com.r2dsolution.comein.centaurs.model.TourTicket;
import com.r2dsolution.comein.centaurs.repository.TourTicketViewRepository;
import com.r2dsolution.comein.centaurs.util.DateUtils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


@Component
public class ViewTourTicketByTourIdFunc extends ComeInFunction{
	
	@Autowired
	TourTicketViewRepository tourTicketViewRepository;
	
	@Autowired
	ComeInMapper comeInMapper;

	@Override
	public ComeInAPIResponse doExecute(ComeInAPIRequest request) throws Exception{
		
//		TourTicketViewRepository repo = ctx.getBean(TourTicketViewRepository.class);
//		
		Map<String,Object> input = request.getJsonBody();
		String tourDateStr = (String) input.get("tour-date");
		int tourIdInt = (int) input.get("tour-id");
		log("param tour-date: "+tourDateStr);
		log("param tour-id: "+tourIdInt);
//		int tourIdInt = 46;
//		String tourDateStr = "2022-12-27";
		TourTicketView v = tourTicketViewRepository.findByTourDateAndTourId(DateUtils.initSQLDate(tourDateStr), new Long(tourIdInt));
		System.out.println("tour-id: "+v.getTourId());
//		output.put("result", ComeInMapper.map((TicketView)v,new TourTicket()));
//		return output;
		Map<String,Object> results = new HashMap<String,Object>();
		results.put("result", comeInMapper.map((TicketView)v,new TourTicket()));
		ComeInAPIResponse response = toComeInResults(results);
		return response;
	}

}
