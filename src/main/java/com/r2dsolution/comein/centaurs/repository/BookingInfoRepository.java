package com.r2dsolution.comein.centaurs.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.r2dsolution.comein.centaurs.entity.BookingInfoM;






public interface BookingInfoRepository extends CrudRepository<BookingInfoM, Long> {

	//public List<BookingInfoM> findByEmail(String email) throws Exception;
	public List<BookingInfoM> findByOwnerId(String comeinId) throws Exception;
	
	@EntityGraph(value = "BookingInfoM.kycInfo", type = EntityGraphType.LOAD)
	public Optional<BookingInfoM> findByBookingNoAndOwnerId(String bookNO, String ownerId)throws Exception;
	
	public Optional<BookingInfoM> findByOtaBookingId(Long otaBookingId)throws Exception;
	public Optional<BookingInfoM> findByBookingNo(String bookno)throws Exception;
	//public Optional<BookingInfoM> findByBookingNoAndHotelId(String bookno,Long hotelId)throws Exception;
	
	@Query(value="select * from booking_info where owner_id is null and ref_email = crypt( :p_email ,salt_key)",nativeQuery = true)
	public List<BookingInfoM> findByReference(@Param("p_email") String ref_email) throws Exception;
	public List<BookingInfoM> findByRefName2(String refname)throws Exception;
//	//public List<BookingInfoM> findByEmailOrCustomerEmail(String email,String customer_email) throws Exception;
//	public List<BookingInfoM> findByOwnerIdOrTargetId(String owner,String target) throws Exception;
//	
//	//public Optional<BookingInfoM> findByBookingNoAndEmail(String bookNO,String email) throws Exception;
//	public Optional<BookingInfoM> findByBookingNoAndOwnerId(String bookNO,String comeinId) throws Exception;
//	
////	@Modifying
////	@Query("update booking_info set customer_email = :p_email, customer_fullname = :p_name where booking_no = :bookno and email = :email")
////	void updateBookInfo(@Param("p_email") String customer_email, @Param("p_name") String customer_name
////			,@Param("email") String email , @Param("bookno") String bookno );
////	
////	
//
//	
	@Modifying
	@Query(value="update booking_info set owner_id = :p_owner, ref_name2 = NULL,ref_name = COALESCE(ref_name2,ref_name) where id = :p_id",nativeQuery = true)
	void updateBookInfoById(@Param("p_owner") String owner_id,@Param("p_id")Long id);
	
	@Modifying
	@Query(value="update booking_info set ref_name2 = :p_name where booking_no = :p_bookno and owner_id = :p_owner",nativeQuery = true)
	void updateRefBookInfo(@Param("p_name") String ref_name, @Param("p_owner") String owner_id , @Param("p_bookno") String bookno );
	
	@Modifying
	@Query(value="update booking_info set ref_name2 = NULL where booking_no = :p_bookno and owner_id = :p_owner",nativeQuery = true)
	void resetRefBookInfo( @Param("p_owner") String owner_id , @Param("p_bookno") String bookno );
	
	
	@Query(value="select hotel_id from booking_info where owner_id = :p_owner and :p_date between checkin and checkout",nativeQuery = true)
	public Set<Long> findTopupByTourDate(@Param("p_owner") String owner_id,@Param("p_date") java.sql.Date tour_date) throws Exception;
	

	
	
//	@Modifying
//	@Query("update booking_info set customer_email = null, customer_fullname = :p_name where booking_no = :bookno and email = :email")
//	void resetBookInfo( @Param("p_name") String customer_name
//			,@Param("email") String email , @Param("bookno") String bookno );
}
