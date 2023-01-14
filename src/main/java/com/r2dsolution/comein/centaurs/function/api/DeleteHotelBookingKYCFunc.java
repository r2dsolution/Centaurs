package com.r2dsolution.comein.centaurs.function.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.r2dsolution.comein.centaurs.business.ViewKYCBookingDelegate;
import com.r2dsolution.comein.centaurs.entity.BookingInfoM;
import com.r2dsolution.comein.centaurs.function.ComeInFunction;
import com.r2dsolution.comein.centaurs.function.ComeInAPIRequest;
import com.r2dsolution.comein.centaurs.function.ComeInAPIResponse;
import com.r2dsolution.comein.centaurs.model.HotelBooking;
import com.r2dsolution.comein.centaurs.repository.BookingInfoRepository;


@Component
public class DeleteHotelBookingKYCFunc extends ComeInFunction{
	
	@Autowired
	BookingInfoRepository repo;
	
	@Autowired
	ViewKYCBookingDelegate viewKYCBookingDelegate;

	@Override
	public ComeInAPIResponse doExecute(ComeInAPIRequest request) throws Exception {
		String bookno = request.toQueryStr("book-no");
		Map<String,Object> input = request.getJsonBody();
		Map<String,Object> output = new HashMap<String,Object>();
		//String profile_email = input.getProfile().getEmail();
		String ownerId = request.getProfile().getComeinId();
		//BookingInfoRepository repo = ctx.getBean(BookingInfoRepository.class);
		log("book-no: "+bookno+" ,owner-id: "+ownerId);
		Optional<BookingInfoM> bookInfoOpt = repo.findByBookingNoAndOwnerId(bookno, ownerId);
		if (bookInfoOpt.isPresent()) {
			String refId = (String) input.get("card-id");
			String refType = (String) input.get("card-type");
			log("refId="+refId+" ownerId="+ownerId);
			BookingInfoM bookInfo = bookInfoOpt.get();
			
			bookInfo.removeBookingKYC(refId);
			repo.save(bookInfo);
			log("delete success");
//			BookingInfoM result = repo.findById(bookInfo.getId()).get();
//			DelegateFactory factory = ctx.getBean(DelegateFactory.class);
//			 ViewKycBookingDelegate bd =  factory.initViewKycBookingDelegate(context);
			 HotelBooking book  = viewKYCBookingDelegate.viewHotelBooking(bookno, ownerId);
			//output.put("hotel-booking", result);
			output.put("result", book);
			output.put("bookno",bookno);
		}
		
		
		return toComeInResults(output);
	}

}
