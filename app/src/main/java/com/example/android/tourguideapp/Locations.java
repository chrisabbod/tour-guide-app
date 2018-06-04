package com.example.android.tourguideapp;

public class Locations {

    private String mLocationName, mLocationDetails, mLocationAddress, mPhoneNumber;
    private int mImageResource;
    private double mLatitude, mLongitude;

    Locations(String locationName, int imageResource){
        mLocationName = locationName;
        mImageResource = imageResource;
    }

    Locations(String locationName, String locationDetails, String locationAddress, String phoneNumber, int imageResource, double latitude, double longitude){
        mLocationName = locationName;
        mLocationDetails = locationDetails;
        mLocationAddress = locationAddress;
        mPhoneNumber = phoneNumber;
        mImageResource = imageResource;
        mLatitude = latitude;
        mLongitude = longitude;
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

    public String getLocationAddress() {
        return mLocationAddress;
    }

    public void setLocationAddress(String mLocationAddress) {
        this.mLocationAddress = mLocationAddress;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(double mLatitude) {
        this.mLatitude = mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(double mLongitude) {
        this.mLongitude = mLongitude;
    }
}