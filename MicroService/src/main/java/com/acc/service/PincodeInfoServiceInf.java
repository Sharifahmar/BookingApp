package com.acc.service;

import com.acc.dto.PinCodeDTO;

public interface PincodeInfoServiceInf {

	public abstract PinCodeDTO getPincodeById(int id) throws Exception;

	public abstract boolean isPincodeActive(int pincodeId);

}