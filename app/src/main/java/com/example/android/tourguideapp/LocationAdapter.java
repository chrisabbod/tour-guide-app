package com.example.android.tourguideapp;

import android.app.Activity;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Locations> {

    public LocationAdapter(Activity context, ArrayList<Locations> locations){
        super(context, 0, locations);
    }
}
