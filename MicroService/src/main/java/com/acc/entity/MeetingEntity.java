package com.acc.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Meeting")
public class MeetingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dateid")
	private int dateId;

	@Temporal(TemporalType.DATE)
	@Column(name = "startdate")
	private Date startDate;

	@Column(name = "starttime")
	private String startTime;

	@Column(name = "enddate")
	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Column(name = "endtime")
	private String endTime;

	@Column(name = "attendee")
	private String attendee;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	private UserEntity userEntity;

	@Column(name = "isactive")
	private String isActive;

	public MeetingEntity() {
        super();
    }



	public int getDateId() {
		return dateId;
	}



	public void setDateId(int dateId) {
		this.dateId = dateId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getAttendee() {
		return attendee;
	}

	public void setAttendee(String attendee) {
		this.attendee = attendee;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}



	public String getIsActive() {
		return isActive;
	}



	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}





	@Override
	public String toString() {
		return "MeetingEntity [dateId=" + dateId + ", startDate=" + startDate
				+ ", startTime=" + startTime + ", endDate=" + endDate
				+ ", endTime=" + endTime + ", attendee=" + attendee
				+ ", userEntity=" + userEntity + "]";
	}

}
