package com.acc.service;

import com.acc.dto.InfoDTO;

public interface MeetingInfoServiceInf {

	public abstract InfoDTO getMeetingById(int id) throws Exception;

	public abstract boolean isMeetingActive(int dateId);

	public abstract Integer addMeeting(InfoDTO dto) throws Exception;

	public abstract InfoDTO updateMeeting(InfoDTO dto);

	public abstract int cancelMeetingServiceImpl(int dateId);

}