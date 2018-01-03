package com.acc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "addressid")
	private int addressId;

	@Column(name = "address1")
	private String address1;

	@Column(name = "address2")
	private String address2;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", unique = true)
	private UserEntity userEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pincodeid")
	private PinCodeEntity pinCodeEntity;

	@Column(name = "isactive")
	private String stat;

	

	public AddressEntity() {
		super();
		// TODO Auto-generated constructor stub
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

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public PinCodeEntity getPinCodeEntity() {
		return pinCodeEntity;
	}

	public void setPinCodeEntity(PinCodeEntity pinCodeEntity) {
		this.pinCodeEntity = pinCodeEntity;
	}

	public AddressEntity(int addressId, String address1, String address2,
			UserEntity userEntity, PinCodeEntity pinCodeEntity, String stat) {
		super();
		this.addressId = addressId;
		this.address1 = address1;
		this.address2 = address2;
		this.userEntity = userEntity;
		this.pinCodeEntity = pinCodeEntity;
		this.stat = stat;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	@Override
	public String toString() {
		return "AddressEntity [addressId=" + addressId + ", address1="
				+ address1 + ", address2=" + address2 + ", userEntity="
				+ userEntity + ", pinCodeEntity=" + pinCodeEntity + "]";
	}

}
