package com.acc.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PinCodeDTO {

    private int pinCodeId;

    private String country;

    private String state;

    private String district;

    private String town;

    private String village;

    public PinCodeDTO(int pinCodeId, String country, String state,
                      String district, String town, String village) {
        super();
        this.pinCodeId = pinCodeId;
        this.country = country;
        this.state = state;
        this.district = district;
        this.town = town;
        this.village = village;
    }

    public PinCodeDTO() {
        super();

    }

    public int getPinCodeId() {

        return pinCodeId;
    }

    public void setPinCodeId(int pinCodeId) {

        this.pinCodeId = pinCodeId;
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

    @Override
    public String toString() {

        return "PinCodeDTO [pinCodeId=" + pinCodeId + ", country=" + country
            + ", state=" + state + ", district=" + district + ", town=" + town
            + ", village=" + village + "]";
    }

}
