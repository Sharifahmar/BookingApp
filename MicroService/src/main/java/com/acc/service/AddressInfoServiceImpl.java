/**
 *
 */
package com.acc.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acc.dao.AddressDAO;
import com.acc.dto.InfoDTO;
import com.acc.entity.AddressEntity;

/**
 * @author ahmar.akhtar.sharif
 *
 */
@Repository
public class AddressInfoServiceImpl implements InfAddressInfoService {

	@Autowired
	private AddressDAO addressDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.AddressInfoServiceInf#isAddressActive(int)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.InfAddressInfoService#isAddressActive(int)
	 */
	@Override
	public boolean isAddressActive(int addressId) {

		boolean status = false;
		AddressEntity en = addressDAO.findByAddressId(addressId);
		InfoDTO dto = new InfoDTO();
		BeanUtils.copyProperties(en, dto);
		String stat = dto.getStat();
		if ("true".equals(stat)) {
			status = true;
		}
		return status;
	}

}
