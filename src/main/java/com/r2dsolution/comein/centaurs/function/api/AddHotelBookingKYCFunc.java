package com.r2dsolution.comein.centaurs.function.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.r2dsolution.comein.centaurs.business.ViewKYCBookingDelegate;
import com.r2dsolution.comein.centaurs.entity.BookingInfoM;
import com.r2dsolution.comein.centaurs.entity.BookingKYCInfoM;
import com.r2dsolution.comein.centaurs.entity.UserKYCInfoM;
import com.r2dsolution.comein.centaurs.function.ComeInFunction;
import com.r2dsolution.comein.centaurs.function.ComeInAPIRequest;
import com.r2dsolution.comein.centaurs.function.ComeInAPIResponse;
import com.r2dsolution.comein.centaurs.model.HotelBooking;
import com.r2dsolution.comein.centaurs.repository.BookingInfoRepository;
import com.r2dsolution.comein.centaurs.repository.UserKYCRepository;


@Component
public class AddHotelBookingKYCFunc  extends ComeInFunction{
	
	@Autowired
	private BookingInfoRepository repo;
	
	@Autowired
	private UserKYCRepository kycRepo;
	
	@Autowired
	private ViewKYCBookingDelegate viewKycBookingDelegate;

	@Override
	public ComeInAPIResponse doExecute(ComeInAPIRequest request) throws Exception {
		try {
			Map<String,Object> input = request.getJsonBody();
			String bookno = request.toQueryStr("book-no");
			//String profile_email = input.getProfile().getEmail();
			String comeinId = request.getProfile().getComeinId();
			//BookingInfoRepository repo = ctx.getBean(BookingInfoRepository.class);
			//log("book-no: "+bookno+" ,profile_email: "+profile_email);
			log("book-no: "+bookno+" ,comein-id: "+comeinId);
			//Optional<BookingInfoM> bookInfoOpt = repo.findByBookingNoAndEmail(bookno, profile_email);
			Optional<BookingInfoM> bookInfoOpt = repo.findByBookingNoAndOwnerId(bookno,comeinId);
			
			 Map<String,Object> output = new HashMap<String,Object>();
			
			if (bookInfoOpt.isPresent()) {
				BookingInfoM bookInfo = bookInfoOpt.get();
				log("book-no: "+bookInfo.getBookingNo());
				
				//UserKYCRepository kycRepo = ctx.getBean(UserKYCRepository.class);
				
				String cardId = (String) input.get("card-id");
				String cardType = (String) input.get("card-type");
				log("cardId: "+cardId+" , cardType: "+cardType);
				
				UserKYCInfoM user = kycRepo.findByRefIdAndRefTypeAndOwnerId(cardId, cardType, comeinId);
				if (user!=null) {
					//log("user firstname: "+user.getFirstname());
					log("user ref-id: "+user.getRefId()+", ref-type: "+user.getRefType());
					BookingKYCInfoM bookKYC = new BookingKYCInfoM(user);
					
					bookInfo.addBookingKYC(bookKYC);
					repo.save(bookInfo);
					log("update success");
					
//					DelegateFactory factory = ctx.getBean(DelegateFactory.class);
//					 ViewKycBookingDelegate bd =  factory.initViewKycBookingDelegate(context);
					 HotelBooking book  = viewKycBookingDelegate.viewHotelBooking(bookno, comeinId);
					
					
					//output.put("hotel-booking",result);
					output.put("result",book);
					output.put("book-no",bookno);
					
				}
			}
			ComeInAPIResponse response = toComeInResults(output);
			return response;
		} catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	
}
