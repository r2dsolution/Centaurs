package com.r2dsolution.comein.centaurs.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.r2dsolution.comein.centaurs.entity.PDPAInviteTokenM;



public interface PDPAInviteTokenRepository extends CrudRepository<PDPAInviteTokenM, Long> {

	Optional<PDPAInviteTokenM> findByComeinIdAndStatus(String comeinId, String statusActive);

}
