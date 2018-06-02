package com.example.android.tourguideapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Locations> {

    public LocationAdapter(Activity context, ArrayList<Locations> locations){
        super(context, 0, locations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Locations currentLocation = getItem(position);

        TextView textView = (TextView)listItemView.findViewById(R.id.title_text_view);
        textView.setText(currentLocation.getLocationName());

        return listItemView;
    }
}
