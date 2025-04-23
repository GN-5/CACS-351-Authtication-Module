package com.gaurab.auth.model;

public class Address {
    public String country;
    public String region;
    public String district;
    public String addressLine;
    public Boolean isInsideRingRoad;
    public int houseNo;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public Boolean getInsideRingRoad() {
        return isInsideRingRoad;
    }

    public void setInsideRingRoad(Boolean insideRingRoad) {
        isInsideRingRoad = insideRingRoad;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public Address(String country, String region, String district, String addressLine, Boolean isInsideRingRoad, int houseNo) {
        this.country = country;
        this.region = region;
        this.district = district;
        this.addressLine = addressLine;
        this.isInsideRingRoad = isInsideRingRoad;
        this.houseNo = houseNo;
    }
}
