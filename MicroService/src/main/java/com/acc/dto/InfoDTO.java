package com.acc.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * This is Info DTO
 * @author ahmar.akhtar.sharif
 *
 */
@XmlRootElement
public class InfoDTO {

    // user
    private int userId;

    private String email;

    private String password;

    private String firstName;

    private String middleName;

    private String lastName;

    private String gender;

    private String dob;

    private String mobile;

    private String landline;

    private Integer uniqueId;

    private String relation;

    private String status;

    private String image;

    private String active;

    // address

    private int addressId;

    private String address1;

    private String address2;

    private String stat;

    // pincode
    private int pinCodeId;

    private String country;

    private String state;

    private String district;

    private String town;

    private String village;

    private String deleted;

    // meeting
    private int dateId;

    private Date startDate;

    private String startTime;

    private Date endDate;

    private String endTime;

    private String attendee;

    private String isActive;

    public InfoDTO() {
        super();

    }

    public String getActive() {

        return active;
    }

    public void setActive(String active) {

        this.active = active;
    }

    public String getStat() {

        return stat;
    }

    public void setStat(String stat) {

        this.stat = stat;
    }

    public String getDeleted() {

        return deleted;
    }

    public void setDeleted(String deleted) {

        this.deleted = deleted;
    }

    public String getIsActive() {

        return isActive;
    }

    public void setIsActive(String isActive) {

        this.isActive = isActive;
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {

        this.userId = userId;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public int getPinCodeId() {

        return pinCodeId;
    }

    public void setPinCodeId(int pinCodeId) {

        this.pinCodeId = pinCodeId;
    }

    public String getFirstName() {

        return firstName;
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

    public Integer getUniqueId() {

        return uniqueId;
    }

    public void setUniqueId(Integer uniqueId) {

        this.uniqueId = uniqueId;
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

    public void setImage(String image) {

        this.image = image;
    }

    public int getAddressId() {

        return addressId;
    }

    public void setAddressId(int addressId) {

        this.addressId = addressId;
    }

    public String getAddress1() {

        return address1;
    }

    public void setAddress1(String address1) {

        this.address1 = address1;
    }

    public String getAddress2() {

        return address2;
    }

    public void setAddress2(String address2) {

        this.address2 = address2;
    }

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {

        this.country = country;
    }

    public String getState() {

        return state;
    }

    public void setState(String state) {

        this.state = state;
    }

    public String getDistrict() {

        return district;
    }

    public void setDistrict(String district) {

        this.district = district;
    }

    public String getTown() {

        return town;
    }

    public void setTown(String town) {

        this.town = town;
    }

    public String getVillage() {

        return village;
    }

    public void setVillage(String village) {

        this.village = village;
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

    @Override
    public String toString() {

        return "InfoDTO [userId=" + userId + ", email=" + email + ", password="
            + password + ", firstName=" + firstName + ", middleName="
            + middleName + ", lastName=" + lastName + ", gender=" + gender
            + ", dob=" + dob + ", mobile=" + mobile + ", landline=" + landline
            + ", uniqueId=" + uniqueId + ", relation=" + relation + ", status="
            + status + ", image=" + image + ", addressId=" + addressId
            + ", address1=" + address1 + ", address2=" + address2
            + ", pinCodeId=" + pinCodeId + ", country=" + country + ", state="
            + state + ", district=" + district + ", town=" + town + ", village="
            + village + ", dateId=" + dateId + ", startDate=" + startDate
            + ", startTime=" + startTime + ", endDate=" + endDate + ", endTime="
            + endTime + ", attendee=" + attendee + "]";
    }

	public InfoDTO(int userId, String email, String password, String firstName,
			String middleName, String lastName, String gender, String dob,
			String mobile, String landline, Integer uniqueId, String relation,
			String status, String image, String active, int addressId,
			String address1, String address2, String stat, int pinCodeId,
			String country, String state, String district, String town,
			String village, String deleted, int dateId, Date startDate,
			String startTime, Date endDate, String endTime, String attendee,
			String isActive) {
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
		this.active = active;
		this.addressId = addressId;
		this.address1 = address1;
		this.address2 = address2;
		this.stat = stat;
		this.pinCodeId = pinCodeId;
		this.country = country;
		this.state = state;
		this.district = district;
		this.town = town;
		this.village = village;
		this.deleted = deleted;
		this.dateId = dateId;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endDate = endDate;
		this.endTime = endTime;
		this.attendee = attendee;
		this.isActive = isActive;
	}
    
    

}
