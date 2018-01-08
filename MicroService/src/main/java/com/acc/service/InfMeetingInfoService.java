package com.acc.service;

import com.acc.customexception.MeetingException;
import com.acc.customexception.UserInfoNotFound;
import com.acc.dto.InfoDTO;

public interface InfMeetingInfoService {

	/** 
	 * This method is to get all the details by meeting id
	 */
	InfoDTO getMeetingById(int id) throws UserInfoNotFound;

	/** 
	 * This method is used to check active status of meeting
	 */
	boolean isMeetingActive(int dateId);

	/** 
	 * This method is used to addmeeting details
	 */
	Integer addMeeting(InfoDTO dto) throws MeetingException;

	/** 
	 * This method is used to update meeting details
	 * 
	 */
	InfoDTO updateMeeting(InfoDTO dto);

	/** 
	 * This method is used for meeting cancellation
	 */
	int cancelMeetingServiceImpl(int dateId);

}