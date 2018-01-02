package com.acc.service;

import com.acc.customexception.PinCodeNotFoundException;
import com.acc.dto.PinCodeDTO;

public interface InfPincodeInfoService {

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.service.PincodeInfoServiceInf#getPincodeById(int)
	 */
	/* (non-Javadoc)
	 * @see com.acc.service.demo#getPincodeById(int)
	 */
	PinCodeDTO getPincodeById(int id) throws PinCodeNotFoundException;

	boolean isPincodeActive(int pincodeId);

}