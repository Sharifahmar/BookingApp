package com.acc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * This is PincodeEntity class
 * @author ahmar.akhtar.sharif
 *
 */
@Entity
@Table(name = "pincode")
public class PinCodeEntity {

    @Id
    @Column(name = "pincodeid")
    private int pinCodeId;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "district")
    private String district;

    @Column(name = "town")
    private String town;

    @Column(name = "village")
    private String village;

    @Column(name = "isactive")
    private String deleted;

    public PinCodeEntity() {
        super();

    }

    public PinCodeEntity(int pinCodeId, String country, String state,
                         String district, String town, String village,
                         String deleted) {
        super();
        this.pinCodeId = pinCodeId;
        this.country = country;
        this.state = state;
        this.district = district;
        this.town = town;
        this.village = village;
        this.deleted = deleted;

    }

    public String getDeleted() {

        return deleted;
    }

    public void setDeleted(String deleted) {

        this.deleted = deleted;
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

        return "PinCodeEntity [pinCodeId=" + pinCodeId + ", country=" + country
            + ", state=" + state + ", district=" + district + ", town=" + town
            + ", village=" + village + "]";
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result =
            prime * result + ((district == null) ? 0 : district.hashCode());
        result = prime * result + pinCodeId;
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((town == null) ? 0 : town.hashCode());
        result = prime * result + ((village == null) ? 0 : village.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof PinCodeEntity))
            return false;
        PinCodeEntity other = (PinCodeEntity) obj;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (district == null) {
            if (other.district != null)
                return false;
        } else if (!district.equals(other.district))
            return false;
        if (pinCodeId != other.pinCodeId)
            return false;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        if (town == null) {
            if (other.town != null)
                return false;
        } else if (!town.equals(other.town))
            return false;
        if (village == null) {
            if (other.village != null)
                return false;
        } else if (!village.equals(other.village))
            return false;
        return true;
    }

}
