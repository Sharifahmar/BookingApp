package com.acc.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
public class UserInfoServiceImpl implements UserInfoServiceInf {

	Logger log = Logger.getLogger(UserInfoServiceImpl.class);

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private AddressDAO addressDAO;

	@Autowired
	private PinCodeDAO pinCodeDAO;

	@Autowired
	private MeetingDAO meetingDAO;

	/* (non-Javadoc)
	 * @see com.acc.service.UserInfoServiceInf#getAllUsers()
	 */
	@Override
	public List<InfoDTO> getAllUsers() throws Exception {
		List<InfoDTO> list = new ArrayList<InfoDTO>();
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
			throw (e);
		}
		return list;

	}

	/* (non-Javadoc)
	 * @see com.acc.service.UserInfoServiceInf#getMeetingById(int)
	 */
	@Override
	public InfoDTO getMeetingById(int id) throws Exception {
		InfoDTO dto = null;
		try {
			MeetingEntity men = meetingDAO.findMeetingId(id);
			if (men != null) {
				dto = new InfoDTO();
				BeanUtils.copyProperties(men, dto);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw (e);
		}
		return dto;
	}

	/* (non-Javadoc)
	 * @see com.acc.service.UserInfoServiceInf#getPincodeById(int)
	 */
	@Override
	public PinCodeDTO getPincodeById(int id) throws Exception {
		PinCodeDTO dto = null;
		try {
			PinCodeEntity pen = pinCodeDAO.findOne(id);
			if (pen != null) {
				dto = new PinCodeDTO();
				BeanUtils.copyProperties(pen, dto);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw (e);
		}

		return dto;

	}

	/* (non-Javadoc)
	 * @see com.acc.service.UserInfoServiceInf#addUser(com.acc.dto.InfoDTO)
	 */
	@Override
	public Integer addUser(InfoDTO dto) throws Exception {
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
			throw (e);
		}

	}

//	public Integer addMeeting(InfoDTO dto) throws Exception {
//
//		MeetingEntity meetingEntity = new MeetingEntity();
//		UserEntity userEntity = new UserEntity();
//		
//		
//			userEntity = userDAO.findByUserId(dto.getUserId());
//			
//		meetingEntity.setUserEntity(userEntity);
//		BeanUtils.copyProperties(dto, meetingEntity);
//		//System.out.println("1...>"+meetingEntity);
//		MeetingEntity entity = meetingDAO.save(meetingEntity);
//		return entity.getDateId();
//		
//
//	}

	/* (non-Javadoc)
	 * @see com.acc.service.UserInfoServiceInf#updateUser(com.acc.dto.InfoDTO)
	 */
	@Override
	public Integer updateUser(InfoDTO dto) throws Exception {
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
			throw (e);
		}

		if (obj != null)
			return 1;
		else
			return 0;
	}

	/* (non-Javadoc)
	 * @see com.acc.service.UserInfoServiceInf#deleteUser(int)
	 */
	@Override
	public void deleteUser(int uid) {
		try {
			UserEntity userEntity = new UserEntity();
			AddressEntity addressEntity = new AddressEntity();
			MeetingEntity meetingEntity = new MeetingEntity();
			meetingEntity = meetingDAO.findMeetingId(uid);

			meetingEntity.setIsActive("false");
			meetingDAO.save(meetingEntity);
			// meetingDAO.delete(meetingEntity.getDateId());
			addressEntity = addressDAO.findAddressbyUserId(uid);

			addressEntity.setStat("false");
			userEntity = userDAO.findByUserId(addressEntity.getUserEntity()
					.getUserId());
			userEntity.setActive("false");

			addressEntity.setUserEntity(userEntity);

			addressDAO.save(addressEntity);
			// addressDAO.delete(addressEntity.getAddressId());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw (e);
		}

	}

	/* (non-Javadoc)
	 * @see com.acc.service.UserInfoServiceInf#findUserById(int)
	 */
	@Override
	public Boolean findUserById(int id) {
		UserEntity entity = new UserEntity();
		try {
			entity = userDAO.findByUserId(id);
			if (entity == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw (e);
		}

	}

	/* (non-Javadoc)
	 * @see com.acc.service.UserInfoServiceInf#isUserExist(com.acc.dto.InfoDTO)
	 */
	@Override
	public Boolean isUserExist(InfoDTO dto) {
		UserEntity entity = new UserEntity();

		try {
			entity = userDAO.findUserByEmail(dto.getEmail());
			if (entity == null) {
				return false;
			} else {
				return true;
			}

		} catch (Exception e) {
			log.error(e.getMessage());
			throw (e);
		}

	}

	/* (non-Javadoc)
	 * @see com.acc.service.UserInfoServiceInf#isUserExistById(com.acc.dto.InfoDTO)
	 */
	@Override
	public Boolean isUserExistById(InfoDTO dto) {
		UserEntity entity = new UserEntity();
		try {
			entity = userDAO.findByUserId(dto.getUserId());
			if (entity == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw (e);
		}

	}

	/* (non-Javadoc)
	 * @see com.acc.service.UserInfoServiceInf#login(com.acc.dto.LoginDTO)
	 */
	@Override
	public InfoDTO login(LoginDTO loginDTO) throws Exception {
		InfoDTO dto = new InfoDTO();
		UserEntity userEntity = null;

		userEntity = userDAO.loginByUserName(loginDTO.getUsername());
		
	//	System.out.println("1...>"+userEntity);

		if (userEntity != null) {
			AddressEntity addressEntity = addressDAO
					.findAddressbyUserId(userEntity.getUserId());
			MeetingEntity meetingEntity = meetingDAO.findMeetingId(userEntity
					.getUserId());
			if (addressEntity != null) {
				if (addressEntity.getUserEntity().getPassword()
						.equals(loginDTO.getPassword())) {
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
						throw (e);
					}
				} else {
					dto = null;
				}
			}
		} else {
			dto = null;
		}
		return dto;
	}

//	public InfoDTO updateMeeting(InfoDTO dto) {
//		InfoDTO dto1 = new InfoDTO();
//		try {
//			UserEntity entity = userDAO.findOne(dto.getUserId());
//			UserEntity entity2 = new UserEntity();
//			MeetingEntity mEntity = new MeetingEntity();
//			if (entity != null) {
//				mEntity=meetingDAO.findMeetingId(dto.getUserId());
//				//System.out.println("1.....>"+mEntity);
//				if(mEntity!=null){
//				BeanUtils.copyProperties(dto, mEntity);
//				BeanUtils.copyProperties(dto, entity2);
//				mEntity.setIsActive("true");
//				mEntity.setUserEntity(entity2);
//				MeetingEntity temp3 = meetingDAO.save(mEntity);
//				BeanUtils.copyProperties(dto, dto1);
//				BeanUtils.copyProperties(temp3, dto1);
//				}else{
//					addMeeting(dto);
//				}
//
//			}
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
//		return dto1;
//	}
	
//	public int  cancelMeetingServiceImpl(int dateId){
//		int result=0;
//		boolean stat=isMeetingActive(dateId);
//		if(stat==false){
//			throw new RuntimeException("Meeting already deleted!");
//		}
//		MeetingEntity en=meetingDAO.findOne(dateId);
//		en.setIsActive("false");
//		meetingDAO.save(en);
//		result=en.getDateId();
//		InfoDTO dto=new InfoDTO();
//		BeanUtils.copyProperties(en, dto);
//		return result;
//		
//	}
	
//	public boolean isMeetingActive(int dateId){
//		boolean status=false;
//		MeetingEntity en=meetingDAO.findByDateId(dateId);
//		InfoDTO dto=new InfoDTO();
//		BeanUtils.copyProperties(en, dto);
//		String stat=dto.getIsActive();
//		log.debug("Getting status: ["+stat+"]");
//		if(stat.equals("true")){
//			status=true;
//		}
//		else{
//			status=false;
//		}
//		log.debug("Getting final status : ["+status+"]");
//		return status;
//	}
	
//	public boolean isAddressActive(int addressId){
//		boolean status=false;
//		AddressEntity en=addressDAO.findByAddressId(addressId);
//		InfoDTO dto=new InfoDTO();
//		BeanUtils.copyProperties(en, dto);
//		String stat=dto.getStat();
//		if(stat.equals("true")){
//			status=true;
//		}
//		return status;
//	}
	
	/* (non-Javadoc)
	 * @see com.acc.service.UserInfoServiceInf#isUserActive(int)
	 */
	@Override
	public boolean isUserActive(int userId){
		boolean status=false;
		UserEntity en=userDAO.findByUserId(userId);
		InfoDTO dto=new InfoDTO();
		BeanUtils.copyProperties(en, dto);
		String stat=dto.getActive();
		if(stat.equals("true")){
			status=true;
		}
		return status;
	}
	
//	public boolean isPincodeActive(int pincodeId){
//		boolean status=false;
//		PinCodeEntity en=pinCodeDAO.findByPinCodeId(pincodeId);
//		InfoDTO dto=new InfoDTO();
//		BeanUtils.copyProperties(en, dto);
//		String stat=dto.getDeleted();
//		if(stat.equals("true")){
//			status=true;
//		}
//		return status;
//	}
}
