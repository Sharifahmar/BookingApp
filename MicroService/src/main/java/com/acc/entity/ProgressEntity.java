package com.acc.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="progressnote")
public class ProgressEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="progressid")
	private int progressId;
	
	@Column(name="progressnote")
	private String progressNote;
	
	@Column(name="createddate")
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name="updateddate")
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
	
	@Column(name="active")
	private String active;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pid")
	private PriorityEntity priorityEntity;


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

	
	
	public PriorityEntity getPriorityEntity() {
		return priorityEntity;
	}

	public void setPriorityEntity(PriorityEntity priorityEntity) {
		this.priorityEntity = priorityEntity;
	}

	public ProgressEntity() {
		super();
	}

	public ProgressEntity(int progressId, String progressNote,
			Date createdDate, Date updatedDate, String active,
			PriorityEntity priorityEntity) {
		super();
		this.progressId = progressId;
		this.progressNote = progressNote;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.active = active;
		this.priorityEntity = priorityEntity;
	}

	
	
	
	
}
