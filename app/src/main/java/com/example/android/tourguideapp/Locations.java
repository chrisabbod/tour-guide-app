package com.example.android.tourguideapp;

public class Locations {

    private String mLocationName, mLocationDetails, mLocationAddress, mLocationHours;
    private int mImageResource;

    Locations(String locationName){
        mLocationName = locationName;
    }

    Locations(String locationName, int imageResource){
        mLocationName = locationName;
        mImageResource = imageResource;
    }

    public String getLocationName() {
        return mLocationName;
    }

    public void setLocationName(String mLocationName) {
        this.mLocationName = mLocationName;
    }

    public String getLocationDetails() {
        return mLocationDetails;
    }

    public void setLocationDetails(String mLocationDetails) {
        this.mLocationDetails = mLocationDetails;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public void setImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getmLocationAddress() {
        return mLocationAddress;
    }

    public void setmLocationAddress(String mLocationAddress) {
        this.mLocationAddress = mLocationAddress;
    }

    public String getmLocationHours() {
        return mLocationHours;
    }

    public void setmLocationHours(String mLocationHours) {
        this.mLocationHours = mLocationHours;
    }
}