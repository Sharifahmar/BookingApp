package com.acc.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acc.entity.PinCodeEntity;

@Repository
public interface PinCodeDAO extends CrudRepository<PinCodeEntity, Integer> {

	/**
	 * This method is used to get pincode details by using pincodeid
	 * 
	 * @param pincodeId
	 * @return
	 */

	@Query(name = "query11.getPincodeById")
	public PinCodeEntity findByPinCodeId(@Param("val1") int pincodeId);

}
