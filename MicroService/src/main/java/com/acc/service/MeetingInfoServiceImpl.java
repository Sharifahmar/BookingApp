/**
 *
 */
package com.acc.service;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.acc.customexception.MeetingAlreadyDeleteException;
import com.acc.customexception.MeetingException;
import com.acc.customexception.UserInfoNotFound;
import com.acc.dao.MeetingDAO;
import com.acc.dao.UserDAO;
import com.acc.dto.InfoDTO;
import com.acc.entity.MeetingEntity;
import com.acc.entity.UserEntity;

/**
 * @author ahmar.akhtar.sharif
 *
 */
@Profile("MSD_Dev_Profile")
@Repository
public class MeetingInfoServiceImpl implements InfMeetingInfoService {
	@Autowired
	private MeetingDAO meetingDAO;

	@Autowired
	private UserDAO userDAO;

	Logger log = Logger.getLogger(MeetingInfoServiceImpl.class);

	/**
	 * This method is to get all the details by meeting id
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

	/**
	 * This method is used to check active status of meeting
	 */
	@Override
	public boolean isMeetingActive(int dateId) {
		boolean status;
		MeetingEntity en = meetingDAO.findByDateId(dateId);
		InfoDTO dto = new InfoDTO();
		BeanUtils.copyProperties(en, dto);
		String stat = dto.getIsActive();
		log.debug("Getting status: [" + stat + "]");
		if ("true".equals(stat)) {
			status = true;
		} else {
			status = false;
		}
		log.debug("Getting final status : [" + status + "]");
		return status;
	}

	/**
	 * This method is used to addmeeting details
	 */
	@Override
	public Integer addMeeting(InfoDTO dto) throws MeetingException {
		MeetingEntity meetingEntity = new MeetingEntity();
		UserEntity userEntity = userDAO.findByUserId(dto.getUserId());
		meetingEntity.setUserEntity(userEntity);
		BeanUtils.copyProperties(dto, meetingEntity);
		MeetingEntity entity = meetingDAO.save(meetingEntity);
		return entity.getDateId();
	}

	/**
	 * This method is used to update meeting details
	 */
	@Override
	public InfoDTO updateMeeting(InfoDTO dto) {
		InfoDTO dto1 = new InfoDTO();
		try {
			UserEntity entity = userDAO.findOne(dto.getUserId());
			UserEntity entity2 = new UserEntity();
			if (entity != null) {
				MeetingEntity mEntity = meetingDAO.findMeetingId(dto
						.getUserId());
				if (mEntity != null) {
					BeanUtils.copyProperties(dto, mEntity);
					BeanUtils.copyProperties(dto, entity2);
					mEntity.setIsActive("true");
					mEntity.setUserEntity(entity2);
					MeetingEntity temp3 = meetingDAO.save(mEntity);
					BeanUtils.copyProperties(dto, dto1);
					BeanUtils.copyProperties(temp3, dto1);
				} else {
					addMeeting(dto);
				}

			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return dto1;
	}

	/**
	 * This method is used for meeting cancellation
	 * 
	 */
	@Override
	public int cancelMeetingServiceImpl(int dateId) {
		int result;
		boolean stat = isMeetingActive(dateId);
		if (!stat) {
			throw new MeetingAlreadyDeleteException("Meeting already deleted!");
		}
		MeetingEntity en = meetingDAO.findOne(dateId);
		en.setIsActive("false");
		meetingDAO.save(en);
		result = en.getDateId();
		InfoDTO dto = new InfoDTO();
		BeanUtils.copyProperties(en, dto);
		return result;
	}
}
