package com.r2dsolution.comein.centaurs.function.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.r2dsolution.comein.centaurs.entity.view.BookedTourTicketView;
import com.r2dsolution.comein.centaurs.function.ComeInFunction;
import com.r2dsolution.comein.centaurs.function.ComeInAPIRequest;
import com.r2dsolution.comein.centaurs.function.ComeInAPIResponse;
import com.r2dsolution.comein.centaurs.model.ComeInMapper;
import com.r2dsolution.comein.centaurs.repository.BookedTourTicketViewRepository;


@Component
public class ViewTourBookingByCodeFunc  extends ComeInFunction{
	
	@Autowired
	BookedTourTicketViewRepository repo;
	
	@Autowired
	ComeInMapper comeInMapper;
	
	@Override
	public ComeInAPIResponse doExecute(ComeInAPIRequest request) throws Exception {
		try {
		
			Map<String,Object> input = request.getJsonBody();
			Map<String,Object> output = new HashMap<String,Object>();
			
//			BookedTourTicketViewRepository repo = ctx.getBean(BookedTourTicketViewRepository.class);
			
			String code = (String) request.toQueryStr("code");
			String ownerId = request.getProfile().getComeinId();
			log("param booking-code: "+code);
			BookedTourTicketView v = repo.findByCodeAndOwnerId(code, ownerId);
			output.put("result", comeInMapper.map(v));
			
			return toComeInResults(output);
		 } catch (Exception e) {
				e.printStackTrace();
				log("error: "+e.getMessage());
				throw e;
		}
	}

}
