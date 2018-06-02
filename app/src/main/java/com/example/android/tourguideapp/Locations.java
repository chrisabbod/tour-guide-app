package com.example.android.tourguideapp;

public class Locations {

    private String mLocationName;
    private int mImageResource;

    Locations(String locationName){
        mLocationName = locationName;
    }

    public String getLocationName() {
        return mLocationName;
    }

    public void setLocationName(String mLocationName) {
        this.mLocationName = mLocationName;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public void setImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }
}
