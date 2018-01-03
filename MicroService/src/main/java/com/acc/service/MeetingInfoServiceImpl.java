/**
 * 
 */
package com.acc.service;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acc.dao.MeetingDAO;
import com.acc.dao.UserDAO;
import com.acc.dto.InfoDTO;
import com.acc.entity.MeetingEntity;
import com.acc.entity.UserEntity;

/**
 * @author ahmar.akhtar.sharif
 *
 */
@Repository
public class MeetingInfoServiceImpl implements MeetingInfoServiceInf {
	@Autowired
	private MeetingDAO meetingDAO;

	@Autowired
	private UserDAO userDAO;

	Logger log = Logger.getLogger(MeetingInfoServiceImpl.class);

	/* (non-Javadoc)
	 * @see com.acc.service.MeetingInfoServiceInf#getMeetingById(int)
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
	 * @see com.acc.service.MeetingInfoServiceInf#isMeetingActive(int)
	 */
	@Override
	public boolean isMeetingActive(int dateId) {
		boolean status = false;
		MeetingEntity en = meetingDAO.findByDateId(dateId);
		InfoDTO dto = new InfoDTO();
		BeanUtils.copyProperties(en, dto);
		String stat = dto.getIsActive();
		log.debug("Getting status: [" + stat + "]");
		if (stat.equals("true")) {
			status = true;
		} else {
			status = false;
		}
		log.debug("Getting final status : [" + status + "]");
		return status;
	}

	/* (non-Javadoc)
	 * @see com.acc.service.MeetingInfoServiceInf#addMeeting(com.acc.dto.InfoDTO)
	 */
	@Override
	public Integer addMeeting(InfoDTO dto) throws Exception {

		MeetingEntity meetingEntity = new MeetingEntity();
		UserEntity userEntity = new UserEntity();

		userEntity = userDAO.findByUserId(dto.getUserId());

		meetingEntity.setUserEntity(userEntity);
		BeanUtils.copyProperties(dto, meetingEntity);
		// System.out.println("1...>"+meetingEntity);
		MeetingEntity entity = meetingDAO.save(meetingEntity);
		return entity.getDateId();

	}

	/* (non-Javadoc)
	 * @see com.acc.service.MeetingInfoServiceInf#updateMeeting(com.acc.dto.InfoDTO)
	 */
	@Override
	public InfoDTO updateMeeting(InfoDTO dto) {
		InfoDTO dto1 = new InfoDTO();
		try {
			UserEntity entity = userDAO.findOne(dto.getUserId());
			UserEntity entity2 = new UserEntity();
			MeetingEntity mEntity = new MeetingEntity();
			if (entity != null) {
				mEntity = meetingDAO.findMeetingId(dto.getUserId());
				// System.out.println("1.....>"+mEntity);
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

	/* (non-Javadoc)
	 * @see com.acc.service.MeetingInfoServiceInf#cancelMeetingServiceImpl(int)
	 */
	@Override
	public int cancelMeetingServiceImpl(int dateId) {
		int result = 0;
		boolean stat = isMeetingActive(dateId);
		if (stat == false) {
			throw new RuntimeException("Meeting already deleted!");
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
