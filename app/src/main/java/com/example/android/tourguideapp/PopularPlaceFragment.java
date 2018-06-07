package com.example.android.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopularPlaceFragment extends Fragment {
    private static final String STRING_TITLE_KEY = "string_title_index";    //Key index used to pass location title to detail activity
    private static final String STRING_DETAILS_KEY = "string_details_index";
    private static final String STRING_ADDRESS_KEY = "string_address_index";
    private static final String STRING_PHONE_KEY = "string_phone_index";
    private static final String IMAGE_RESOURCE_KEY = "image_resource_index";    //Key index used to pass location image resource file
    private static final String LATITUDE_KEY = "latitude_index";
    private static final String LONGITUDE_KEY = "longitude_index";

    public PopularPlaceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(getString(R.string.fort_wayne), getString(R.string.fort_wayne_details), getString(R.string.fort_wayne_address),
                getString(R.string.fort_wayne_number), R.drawable.fort_wayne, 42.299361, -83.096010));
        locations.add(new Location(getString(R.string.pewabic_pottery), getString(R.string.pewabic_pottery_details),getString(R.string.pewabic_pottery_address),
                getString(R.string.pewabic_pottery_number),R.drawable.pewabic_pottery, 42.362034, -82.981698));
        locations.add(new Location(getString(R.string.renaissance_center), getString(R.string.renaissance_center_details), getString(R.string.renaissance_center_address),
                getString(R.string.renaissance_center_number),R.drawable.renaissance_center, 42.329798, -83.039830));
        locations.add(new Location(getString(R.string.henry_ford_estate), getString(R.string.henry_ford_estate_details),getString(R.string.henry_ford_estate_address),
                getString(R.string.henry_ford_estate_number),R.drawable.henry_ford_estate, 42.312254, -83.225269));
        locations.add(new Location(getString(R.string.comerica_park), getString(R.string.comerica_park_details), getString(R.string.comerica_park_address),
                getString(R.string.comerica_park_number), R.drawable.comerica_park, 42.339189, -83.049478));
        locations.add(new Location(getString(R.string.detroit_public_library), getString(R.string.detroit_public_library_details), getString(R.string.detroit_public_library_address),
                getString(R.string.detroit_public_library_number), R.drawable.detroit_public_library, 42.358543, -83.066777));
        locations.add(new Location(getString(R.string.greektown), getString(R.string.greektown_details), getString(R.string.greektown_address),
                getString(R.string.greektown_number), R.drawable.greektown, 42.335760, -83.042179));

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
                intent.putExtra(LATITUDE_KEY, locations.get(position).getLatitude());
                intent.putExtra(LONGITUDE_KEY, locations.get(position).getLongitude());
                startActivity(intent);
            }
        });

        return rootView;
    }

}
