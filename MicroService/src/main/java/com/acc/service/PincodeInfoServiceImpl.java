/**
 *
 */
package com.acc.service;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acc.customexception.PinCodeNotFoundException;
import com.acc.dao.PinCodeDAO;
import com.acc.dto.InfoDTO;
import com.acc.dto.PinCodeDTO;
import com.acc.entity.PinCodeEntity;

/**
 * @author ahmar.akhtar.sharif
 *
 */
@Repository
public class PincodeInfoServiceImpl implements  InfPincodeInfoService {

	Logger log = Logger.getLogger(PincodeInfoServiceImpl.class);

	@Autowired
	private PinCodeDAO pinCodeDAO;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.service.PincodeInfoServiceInf#getPincodeById(int)
	 */
	/* (non-Javadoc)
	 * @see com.acc.service.demo#getPincodeById(int)
	 */
	/* (non-Javadoc)
	 * @see com.acc.service.InfPincodeService#getPincodeById(int)
	 */
	@Override
	public PinCodeDTO getPincodeById(int id) throws PinCodeNotFoundException {
		PinCodeDTO dto = null;
		try {
			PinCodeEntity pen = pinCodeDAO.findOne(id);
			if (pen != null) {
				dto = new PinCodeDTO();
				BeanUtils.copyProperties(pen, dto);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}

		return dto;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.service.PincodeInfoServiceInf#isPincodeActive(int)
	 */
	/* (non-Javadoc)
	 * @see com.acc.service.demo#isPincodeActive(int)
	 */
	
	/* (non-Javadoc)
	 * @see com.acc.service.InfPincodeService#isPincodeActive(int)
	 */
	@Override
	public boolean isPincodeActive(int pincodeId) {
		boolean status = false;
		PinCodeEntity en = pinCodeDAO.findByPinCodeId(pincodeId);
		InfoDTO dto = new InfoDTO();
		BeanUtils.copyProperties(en, dto);
		String stat = dto.getDeleted();
		if ("true".equals(stat)) {
			status = true;
		}
		return status;
	}
}
