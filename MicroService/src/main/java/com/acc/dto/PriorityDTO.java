package com.acc.dto;

import java.util.Date;
/**
 * This is PriorityDTO
 * @author ahmar.akhtar.sharif
 *
 */

public class PriorityDTO {

	//priority 
	
	private int pid;
	
	private int empId;
	
	private String title;
	
	private Date priorityCreationDate;
	
	private Date priorityUpdatedDate;
	
	private String isActive;
	
	private Date priorityStartDate;
	
	private Date priorityEndDate;
	
	private String status;
	
	
	//progress
	
	private int progressId;
	
	private String progressNote;
	
	private Date createdDate;
	
	private Date updatedDate;

	private String active;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPriorityCreationDate() {
		return priorityCreationDate;
	}

	public void setPriorityCreationDate(Date priorityCreationDate) {
		this.priorityCreationDate = priorityCreationDate;
	}

	public Date getPriorityUpdatedDate() {
		return priorityUpdatedDate;
	}

	public void setPriorityUpdatedDate(Date priorityUpdatedDate) {
		this.priorityUpdatedDate = priorityUpdatedDate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Date getPriorityStartDate() {
		return priorityStartDate;
	}

	public void setPriorityStartDate(Date priorityStartDate) {
		this.priorityStartDate = priorityStartDate;
	}

	public Date getPriorityEndDate() {
		return priorityEndDate;
	}

	public void setPriorityEndDate(Date priorityEndDate) {
		this.priorityEndDate = priorityEndDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getProgressId() {
		return progressId;
	}

	public void setProgressId(int progressId) {
		this.progressId = progressId;
	}

	public String getProgressNote() {
		return progressNote;
	}

	public void setProgressNote(String progressNote) {
		this.progressNote = progressNote;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public PriorityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PriorityDTO(int pid, int empId, String title,
			Date priorityCreationDate, Date priorityUpdatedDate,
			String isActive, Date priorityStartDate, Date priorityEndDate,
			String status, int progressId, String progressNote,
			Date createdDate, Date updatedDate, String active) {
		super();
		this.pid = pid;
		this.empId = empId;
		this.title = title;
		this.priorityCreationDate = priorityCreationDate;
		this.priorityUpdatedDate = priorityUpdatedDate;
		this.isActive = isActive;
		this.priorityStartDate = priorityStartDate;
		this.priorityEndDate = priorityEndDate;
		this.status = status;
		this.progressId = progressId;
		this.progressNote = progressNote;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.active = active;
	}
	
	
	
	
}
