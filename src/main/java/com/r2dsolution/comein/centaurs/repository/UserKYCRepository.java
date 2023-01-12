package com.r2dsolution.comein.centaurs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.r2dsolution.comein.centaurs.entity.UserKYCInfoM;





public interface UserKYCRepository  extends CrudRepository<UserKYCInfoM, Long> {

	//public List<UserKYCInfoM> findByProfile(String email) throws Exception;
	public List<UserKYCInfoM> findByOwnerId(String ownerId) throws Exception;
	//public UserKYCInfoM findByEmailAndKycEmail(String email,String profile_email) throws Exception;
	public UserKYCInfoM findByRefIdAndRefTypeAndOwnerId(String refId,String refType,String ownerId) throws Exception;
	
//	@Modifying
//	@Query("delete from kyc_info  where profile = :profile_email and email = :p_email")
//	void deleteKYCInfo(@Param("p_email") String email, @Param("profile_email") String profile_email);
	
	
//	@Modifying
//	@Query("delete from kyc_info  where owner_id = :p_owner and target_id = :p_target")
//	void deleteKYCInfo(@Param("p_target") String target, @Param("p_owner") String owner);
	
	@Modifying
	@Query(value="delete from kyc_info  where owner_id = :p_owner and ref_id = :p_refId and ref_type = :p_refType",nativeQuery=true)
	void deleteKYCByRef(@Param("p_refId") String refId,@Param("p_refType") String refType, @Param("p_owner") String owner_id);
			
}