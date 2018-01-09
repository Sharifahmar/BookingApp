/**
 *
 */
package com.acc.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.acc.dao.AddressDAO;
import com.acc.dto.InfoDTO;
import com.acc.entity.AddressEntity;

/**
 * @author ahmar.akhtar.sharif
 *
 */
//@Profile("MSD_Dev_Profile") 
@Repository
public class AddressInfoServiceImpl implements InfAddressInfoService {

	@Autowired
	private AddressDAO addressDAO;

	/**
	 * This method is used to check active status of address
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
