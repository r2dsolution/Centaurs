package com.r2dsolution.comein.centaurs.function.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.r2dsolution.comein.centaurs.entity.view.BookedTourTicketView;
import com.r2dsolution.comein.centaurs.function.ComeInAPIRequest;
import com.r2dsolution.comein.centaurs.function.ComeInAPIResponse;
import com.r2dsolution.comein.centaurs.function.ComeInFunction;
import com.r2dsolution.comein.centaurs.model.ComeInMapper;
import com.r2dsolution.comein.centaurs.model.TourTicket;
import com.r2dsolution.comein.centaurs.repository.BookedTourTicketViewRepository;
import com.r2dsolution.comein.centaurs.util.DateUtils;




@Component
public class ListTourBookingByEmailFunc  extends ComeInFunction{
	
	
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
			 
			 
			 List<TourTicket> results = new ArrayList<TourTicket>();
			 
			String email = request.getProfile().getEmail();
			 String ownerId = request.getProfile().getComeinId();
			 log("email:"+email);
			 log("owner-id:"+ownerId);
			 log("sub:"+request.getProfile().getSub());
			 
			//List<BookingInfoM> books = repo.findByEmailOrCustomerEmail(email,email);
			 java.sql.Date now = DateUtils.nowSQLDate();
			 List<BookedTourTicketView> books = repo.findActiveTourBooking(ownerId, now);
//			 List<Booking> books = repo.findByOwnerId(ownerId);
			 log("books size: "+books.size());
			 for(BookedTourTicketView book: books) {

				log("book-id:"+book.getCode());
				TourTicket result = comeInMapper.map(book);
				results.add(result);
				//Long hotelId = book.getHotelId().getId();
//				Long tourId = book.getTourId();
//				Long compId = book.getCompanyId();
//				
//				log("tour-id: "+tourId);
//////				doCache(hotelId,hotelRepo,HotelM.class);
//////				HotelM hotel = getCache(hotelId,HotelM.class);
//			
//				TourInfoM tour = tours.get(tourId);
//				if (tour==null) {
//					Optional<TourInfoM> tourOpt = tourRepo.findById(tourId);
//					if (tourOpt.isPresent()) {
//						tour = tourOpt.get();
//						tours.put(tourId, tour);
//					}
//				}
//				
//				TourCompanyM comp = comps.get(compId);
//				if (comp==null) {
//					Optional<TourCompanyM> compOpt = compRepo.findById(compId);
//					if (compOpt.isPresent()) {
//						comp = compOpt.get();
//						comps.put(compId, comp);
//					}
//				}
//				
//				//HotelM hotel = hotels.get(hotelId);
//				if (comp!=null && tour!=null) {
//					log("book-code: "+book.getBookingCode()+" tour-name: "+comp.getCompanyName());
//					TourTicket result = ComeInMapper.map(book,tour,comp);
//					results.add(result);
//				}
			}
			// Map<String,Object> bookings = toResult("hotel-booking",results);
			 //output.put("email", email);
			 output.put("owner-id", ownerId);
			 output.put("results", results);
			 output.put("size", books.size());
			
			return toComeInResults(output);
		 } catch (Exception e) {
				e.printStackTrace();
				log("error: "+e.getMessage());
				throw e;
		}
	}

}
