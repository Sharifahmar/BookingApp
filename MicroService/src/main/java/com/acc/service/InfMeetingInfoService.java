package com.acc.service;

import com.acc.customexception.MeetingException;
import com.acc.customexception.UserInfoNotFound;
import com.acc.dto.InfoDTO;

public interface InfMeetingInfoService {

	/* (non-Javadoc)
	 * @see com.acc.service.InfMeetingInfoService#getMeetingById(int)
	 */
	InfoDTO getMeetingById(int id) throws UserInfoNotFound;

	/* (non-Javadoc)
	 * @see com.acc.service.InfMeetingInfoService#isMeetingActive(int)
	 */
	boolean isMeetingActive(int dateId);

	/* (non-Javadoc)
	 * @see com.acc.service.InfMeetingInfoService#addMeeting(com.acc.dto.InfoDTO)
	 */
	Integer addMeeting(InfoDTO dto) throws MeetingException;

	/* (non-Javadoc)
	 * @see com.acc.service.InfMeetingInfoService#updateMeeting(com.acc.dto.InfoDTO)
	 */
	InfoDTO updateMeeting(InfoDTO dto);

	/* (non-Javadoc)
	 * @see com.acc.service.InfMeetingInfoService#cancelMeetingServiceImpl(int)
	 */
	int cancelMeetingServiceImpl(int dateId);

}