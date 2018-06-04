package com.example.android.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopularPlacesFragment extends Fragment {
    private static final String STRING_TITLE_KEY = "string_title_index";    //Key index used to pass location title to detail activity
    private static final String STRING_DETAILS_KEY = "string_details_index";
    private static final String STRING_ADDRESS_KEY = "string_address_index";
    private static final String STRING_PHONE_KEY = "string_phone_index";
    private static final String IMAGE_RESOURCE_KEY = "image_resource_index";    //Key index used to pass location image resource file

    public PopularPlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Locations> locations = new ArrayList<>();
        locations.add(new Locations(getString(R.string.fort_wayne), getString(R.string.fort_wayne_details), getString(R.string.fort_wayne_address),
                getString(R.string.fort_wayne_number), R.drawable.fort_wayne, 42.299361, -83.096010));
        locations.add(new Locations(getString(R.string.pewabic_pottery), getString(R.string.pewabic_pottery_details),getString(R.string.pewabic_pottery_address),
                getString(R.string.pewabic_pottery_number),R.drawable.pewabic_pottery, 42.362034, -82.981698));
        //locations.add(new Locations(getString(R.string.renaissance_center), R.drawable.renaissance_center));
        //locations.add(new Locations(getString(R.string.henry_ford_estate), R.drawable.henry_ford_estate));
        //locations.add(new Locations(getString(R.string.comerica_park), R.drawable.comerica_park));
        //locations.add(new Locations(getString(R.string.detroit_public_library), R.drawable.detroit_public_library));
        //locations.add(new Locations(getString(R.string.greektown), R.drawable.greektown));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
        ListView listView = (ListView)rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(STRING_TITLE_KEY, locations.get(position).getLocationName());  //Retrieve location title from selected item and pass to detail activity
                intent.putExtra(STRING_DETAILS_KEY, locations.get(position).getLocationDetails()); //Retrieve location details
                intent.putExtra(STRING_ADDRESS_KEY, locations.get(position).getLocationAddress()); //Retrieve location address
                intent.putExtra(STRING_PHONE_KEY, locations.get(position).getPhoneNumber()); //Retrieve location phone number
                intent.putExtra(IMAGE_RESOURCE_KEY, locations.get(position).getImageResource()); //Pass image resource to detail activity so image can be displayed//Toast.makeText(MainActivity.this, locations.get(position).getImageResource(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        return rootView;
    }

}
