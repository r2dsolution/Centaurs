package com.r2dsolution.comein.centaurs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.r2dsolution.comein.centaurs.entity.view.BookedTourTicketView;





public interface BookedTourTicketViewRepository extends Repository<BookedTourTicketView,String>{
	
	
	BookedTourTicketView findByCodeAndOwnerId(String code,String ownerId);
	
	@Query(value="select * from v_booked_ticket where owner_id = :p_owner and tour_date >= :p_date",nativeQuery=true)
	List<BookedTourTicketView> findActiveTourBooking(@Param("p_owner") String ownerId,@Param("p_date")java.sql.Date tourDate);

}
