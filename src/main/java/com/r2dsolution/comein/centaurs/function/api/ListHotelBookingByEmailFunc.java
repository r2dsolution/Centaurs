package com.r2dsolution.comein.centaurs.function.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.r2dsolution.comein.centaurs.entity.BookingInfoM;
import com.r2dsolution.comein.centaurs.entity.HotelM;
import com.r2dsolution.comein.centaurs.function.ComeInAPIRequest;
import com.r2dsolution.comein.centaurs.function.ComeInAPIResponse;
import com.r2dsolution.comein.centaurs.function.ComeInFunction;
import com.r2dsolution.comein.centaurs.model.ComeInMapper;
import com.r2dsolution.comein.centaurs.model.HotelBooking;
import com.r2dsolution.comein.centaurs.repository.BookingInfoRepository;


@Component
public class ListHotelBookingByEmailFunc extends ComeInFunction{
	
	@Autowired
	BookingInfoRepository repo;
	
	@Autowired
	ComeInMapper comeInMapper;

	@Override
	public ComeInAPIResponse doExecute(ComeInAPIRequest request) throws Exception {
		 
		try {
			Map<String,Object> output = new HashMap<String,Object>();
			 
//			 BookingInfoRepository repo = ctx.getBean(BookingInfoRepository.class);
//			 BookingRepository repo = ctx.getBean(BookingRepository.class);
//			 HotelRepository hotelRepo = ctx.getBean(HotelRepository.class);
			 
			 
			 List<HotelBooking> results = new ArrayList<HotelBooking>();
			 
			String email = request.getProfile().getEmail();
			 String ownerId = request.getProfile().getComeinId();
			 log("email:"+email);
			 log("owner-id:"+ownerId);
			 log("sub:"+request.getProfile().getSub());
			 
			//List<BookingInfoM> books = repo.findByEmailOrCustomerEmail(email,email);
			 List<BookingInfoM> books = repo.findByOwnerId(ownerId);
//			 List<Booking> books = repo.findByOwnerId(ownerId);
			 log("books size: "+books.size());
			 for(BookingInfoM book: books) {

				log("book-id:"+book.getId());
				Long hotelId = book.getHotelInfo().getId();
				log("hotel-id: "+hotelId);
////				doCache(hotelId,hotelRepo,HotelM.class);
////				HotelM hotel = getCache(hotelId,HotelM.class);
//				HotelM hotel = null;
//				Optional<HotelM> hotelOpt = hotelRepo.findById(hotelId);
//				if (hotelOpt.isPresent()) {
//					hotel = hotelOpt.get();
//				}
				//HotelM hotel = hotels.get(hotelId);
				HotelM hotel = book.getHotelInfo();
				if (hotel!=null) {
					log("book-no: "+book.getBookingNo()+" hotel-name: "+hotel.getHotelName());
					HotelBooking result = comeInMapper.map(book,hotel);
					results.add(result);
				}
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
