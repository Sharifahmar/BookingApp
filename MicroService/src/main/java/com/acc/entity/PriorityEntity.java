package com.acc.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * This IS PriorityEntity Class
 * @author ahmar.akhtar.sharif
 *
 */
@Entity
@Table(name="priority")
public class PriorityEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pid")
	private int pid;
	
	@Column(name="empid")
	private int empId;
	
	@Column(name="title")
	private String title;
	
	
	@Column(name="prioritycreationdate")
	@Temporal(TemporalType.DATE)
	private Date priorityCreationDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="priorityupdateddate")
	private Date priorityUpdatedDate;
	
	@Column(name="prioritystartdate")
	@Temporal(TemporalType.DATE)
	private Date priorityStartDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="priorityenddate")
	private Date priorityEndDate;

	@Column(name="isactive")
	private String isActive;
	
	@Column(name="status")
	private String status;

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

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PriorityEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PriorityEntity(int pid, int empId, String title,
			Date priorityCreationDate, Date priorityUpdatedDate,
			Date priorityStartDate, Date priorityEndDate, String isActive,
			String status) {
		super();
		this.pid = pid;
		this.empId = empId;
		this.title = title;
		this.priorityCreationDate = priorityCreationDate;
		this.priorityUpdatedDate = priorityUpdatedDate;
		this.priorityStartDate = priorityStartDate;
		this.priorityEndDate = priorityEndDate;
		this.isActive = isActive;
		this.status = status;
	}

	
	
	
	
	
	
	
}
