package com.acc.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acc.customexception.PinCodeNotFoundException;
import com.acc.customexception.UserInfoNotFound;
import com.acc.dao.AddressDAO;
import com.acc.dao.MeetingDAO;
import com.acc.dao.PinCodeDAO;
import com.acc.dao.UserDAO;
import com.acc.dto.InfoDTO;
import com.acc.dto.LoginDTO;
import com.acc.dto.PinCodeDTO;
import com.acc.entity.AddressEntity;
import com.acc.entity.MeetingEntity;
import com.acc.entity.PinCodeEntity;
import com.acc.entity.UserEntity;

@Repository
public class UserInfoServiceImpl implements InfUserInfoService {

	Logger log = Logger.getLogger(UserInfoServiceImpl.class);

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private AddressDAO addressDAO;

	@Autowired
	private PinCodeDAO pinCodeDAO;

	@Autowired
	private MeetingDAO meetingDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.UserInfoServiceInf#getAllUsers()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.InfUserInfoService#getAllUsers()
	 */
	@Override
	public List<InfoDTO> getAllUsers() throws UserInfoNotFound {
		List<InfoDTO> list = new ArrayList<>();
		try {
			Iterable<AddressEntity> listEn = addressDAO.findByStat("true");
			listEn.forEach(x -> {

				InfoDTO dto = new InfoDTO();
				try {
					BeanUtils.copyProperties(getMeetingById(x.getUserEntity()
							.getUserId()), dto);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				BeanUtils.copyProperties(x, dto);
				BeanUtils.copyProperties(x.getUserEntity(), dto);
				BeanUtils.copyProperties(x.getPinCodeEntity(), dto);
				list.add(dto);

			});
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.UserInfoServiceInf#getMeetingById(int)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.InfUserInfoService#getMeetingById(int)
	 */
	@Override
	public InfoDTO getMeetingById(int id) throws UserInfoNotFound {
		InfoDTO dto = null;
		try {
			MeetingEntity men = meetingDAO.findMeetingId(id);
			if (men != null) {
				dto = new InfoDTO();
				BeanUtils.copyProperties(men, dto);
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
	 * @see com.acc.service.UserInfoServiceInf#getPincodeById(int)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.InfUserInfoService#getPincodeById(int)
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
	 * @see com.acc.service.UserInfoServiceInf#addUser(com.acc.dto.InfoDTO)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.InfUserInfoService#addUser(com.acc.dto.InfoDTO)
	 */
	@Override
	public Integer addUser(InfoDTO dto) throws UserInfoNotFound {
		try {
			UserEntity userEntity = new UserEntity();
			AddressEntity addressEntity = new AddressEntity();
			PinCodeEntity pinCodeEntity = new PinCodeEntity();
			PinCodeDTO dto1 = getPincodeById(dto.getPinCodeId());
			if (dto1 == null) {
				BeanUtils.copyProperties(dto, pinCodeEntity);
				addressEntity.setPinCodeEntity(pinCodeEntity);
			} else {
				addressEntity.setPinCodeEntity(pinCodeDAO.findOne(dto
						.getPinCodeId()));
			}
			BeanUtils.copyProperties(dto, userEntity);
			addressEntity.setUserEntity(userEntity);
			BeanUtils.copyProperties(dto, addressEntity);
			AddressEntity id = addressDAO.save(addressEntity);
			return id.getUserEntity().getUserId();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.UserInfoServiceInf#updateUser(com.acc.dto.InfoDTO)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.InfUserInfoService#updateUser(com.acc.dto.InfoDTO)
	 */
	@Override
	public Integer updateUser(InfoDTO dto) throws UserInfoNotFound {
		Object obj = null;
		try {
			UserEntity entity = userDAO.findOne(dto.getUserId());
			AddressEntity aEntity = new AddressEntity();
			PinCodeEntity pEntity = new PinCodeEntity();
			MeetingEntity mEntity = new MeetingEntity();
			if (entity != null) {
				BeanUtils.copyProperties(dto, entity);
				UserEntity temp1 = userDAO.save(entity);
				BeanUtils.copyProperties(dto, pEntity);
				PinCodeEntity temp = pinCodeDAO.save(pEntity);
				BeanUtils.copyProperties(dto, mEntity);
				BeanUtils.copyProperties(dto, aEntity);
				aEntity.setPinCodeEntity(temp);
				aEntity.setUserEntity(temp1);
				obj = addressDAO.save(aEntity);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}

		if (obj != null)
			return 1;
		else
			return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.UserInfoServiceInf#deleteUser(int)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.InfUserInfoService#deleteUser(int)
	 */
	@Override
	public void deleteUser(int uid) {
		try {
			String statusChange = "false";
			MeetingEntity meetingEntity = meetingDAO.findMeetingId(uid);
			meetingEntity.setIsActive(statusChange);
			meetingDAO.save(meetingEntity);
			AddressEntity addressEntity = addressDAO.findAddressbyUserId(uid);
			addressEntity.setStat(statusChange);
			UserEntity userEntity = userDAO.findByUserId(addressEntity
					.getUserEntity().getUserId());
			userEntity.setActive(statusChange);
			addressEntity.setUserEntity(userEntity);
			addressDAO.save(addressEntity);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.UserInfoServiceInf#findUserById(int)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.InfUserInfoService#findUserById(int)
	 */
	@Override
	public Boolean findUserById(int id) {
		UserEntity entity = new UserEntity();
		try {
			entity = userDAO.findByUserId(id);
			return entity == null;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.UserInfoServiceInf#isUserExist(com.acc.dto.InfoDTO)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.InfUserInfoService#isUserExist(com.acc.dto.InfoDTO)
	 */
	@Override
	public Boolean isUserExist(InfoDTO dto) {
		UserEntity entity = new UserEntity();
		try {
			entity = userDAO.findUserByEmail(dto.getEmail());
			return entity == null;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.acc.service.UserInfoServiceInf#isUserExistById(com.acc.dto.InfoDTO)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.acc.service.InfUserInfoService#isUserExistById(com.acc.dto.InfoDTO)
	 */
	@Override
	public Boolean isUserExistById(InfoDTO dto) {
		UserEntity entity = new UserEntity();
		try {
			entity = userDAO.findByUserId(dto.getUserId());
			return entity == null;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.UserInfoServiceInf#login(com.acc.dto.LoginDTO)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.InfUserInfoService#login(com.acc.dto.LoginDTO)
	 */
	@Override
	public InfoDTO login(LoginDTO loginDTO) throws UserInfoNotFound {
		InfoDTO dto = new InfoDTO();
		UserEntity userEntity;
		userEntity = userDAO.loginByUserName(loginDTO.getUsername());
		if (userEntity != null) {
			getInfoDTO(dto, userEntity, loginDTO);
		} else {
			dto = null;
		}
		return dto;
	}

	private void getInfoDTO(InfoDTO dto, UserEntity userEntity,
			LoginDTO loginDTO) {
		AddressEntity addressEntity = addressDAO.findAddressbyUserId(userEntity
				.getUserId());
		MeetingEntity meetingEntity = meetingDAO.findMeetingId(userEntity
				.getUserId());
		if (addressEntity != null) {
			if (!addressEntity.getUserEntity().getPassword()
					.equals(loginDTO.getPassword())) {
				dto = null;
			}
			BeanUtils.copyProperties(addressEntity, dto);
			BeanUtils.copyProperties(userEntity, dto);
			if (meetingEntity != null) {
				BeanUtils.copyProperties(meetingEntity, dto);
			}
			try {
				BeanUtils.copyProperties(getPincodeById(addressEntity
						.getPinCodeEntity().getPinCodeId()), dto);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.UserInfoServiceInf#isUserActive(int)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.InfUserInfoService#isUserActive(int)
	 */
	@Override
	public boolean isUserActive(int userId) {
		boolean status = false;
		UserEntity en = userDAO.findByUserId(userId);
		InfoDTO dto = new InfoDTO();
		BeanUtils.copyProperties(en, dto);
		String stat = dto.getActive();
		if ("true".equals(stat)) {
			status = true;
		}
		return status;
	}
}
