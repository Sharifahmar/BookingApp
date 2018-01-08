package com.acc.service;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.acc.customexception.PinCodeNotFoundException;
import com.acc.dao.PinCodeDAO;
import com.acc.dto.InfoDTO;
import com.acc.dto.PinCodeDTO;
import com.acc.entity.PinCodeEntity;

/**
 * @author ahmar.akhtar.sharif 
 * This is PincodeInfoSeviceImpl class
 *
 */
@Profile("MSD_Dev_Profile")
@Repository
public class PincodeInfoServiceImpl implements InfPincodeInfoService {

	Logger log = Logger.getLogger(PincodeInfoServiceImpl.class);

	@Autowired
	private PinCodeDAO pinCodeDAO;

	/**
	 * * This method is used to get pincode details by id
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

	/**
	 * This method is used to check active status of pincode
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
