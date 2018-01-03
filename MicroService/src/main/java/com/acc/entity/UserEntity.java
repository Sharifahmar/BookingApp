package com.acc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private int userId;

	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "middlename")
	private String middleName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "dob")
	private String dob;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "landline")
	private String landline;

	@Column(name = "uniqueid")
	private Integer uniqueId;

	@Column(name = "relation")
	private String relation;

	@Column(name = "status")
	private String status;

	@Column(name = "image")
	private String image;
	
	@Column(name="isactive")
	private String active;

	

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(Integer uniqueId) {
		this.uniqueId = uniqueId;
	}

	public UserEntity(int userId, String email, String password,
			String firstName, String middleName, String lastName,
			String gender, String dob, String mobile, String landline,
			Integer uniqueId, String relation, String status, String image, String active) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.mobile = mobile;
		this.landline = landline;
		this.uniqueId = uniqueId;
		this.relation = relation;
		this.status = status;
		this.image = image;
		this.active=active;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", email=" + email
				+ ", password=" + password + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName
				+ ", gender=" + gender + ", dob=" + dob + ", mobile=" + mobile
				+ ", landline=" + landline + ", uniqueId=" + uniqueId
				+ ", relation=" + relation + ", status=" + status + ", image="
				+ image + "]";
	}

}
