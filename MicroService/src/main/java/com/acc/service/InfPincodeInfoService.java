package com.acc.service;

import com.acc.customexception.PinCodeNotFoundException;
import com.acc.dto.PinCodeDTO;

public interface InfPincodeInfoService {

	/**
	 * This method is used to get pincode details by id
	 * @param id
	 * @return
	 * @throws PinCodeNotFoundException
	 */
	PinCodeDTO getPincodeById(int id) throws PinCodeNotFoundException;
	
	/**
	 * This method is used to check active status of pincode
	 * @param pincodeId
	 * @return
	 */

	boolean isPincodeActive(int pincodeId);

}