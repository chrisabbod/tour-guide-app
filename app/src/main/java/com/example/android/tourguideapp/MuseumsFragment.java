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
public class MuseumsFragment extends Fragment {
    private static final String STRING_TITLE_KEY = "string_title_index";    //Key index used to pass location title to detail activity
    private static final String STRING_DETAILS_KEY = "string_details_index";
    private static final String STRING_ADDRESS_KEY = "string_address_index";
    private static final String STRING_PHONE_KEY = "string_phone_index";
    private static final String IMAGE_RESOURCE_KEY = "image_resource_index";    //Key index used to pass location image resource file
    private static final String LATITUDE_KEY = "latitude_index";
    private static final String LONGITUDE_KEY = "longitude_index";

    public MuseumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Locations> locations = new ArrayList<>();
        locations.add(new Locations(getString(R.string.detroit_institute_of_arts), getString(R.string.detroit_institute_of_arts_details), getString(R.string.detroit_institute_of_arts_address),
                getString(R.string.detroit_institute_of_arts_number), R.drawable.detroit_institute_of_arts, 42.359442, -83.064366));
        locations.add(new Locations(getString(R.string.henry_ford_museum), getString(R.string.henry_ford_museum_details), getString(R.string.henry_ford_museum_address),
                getString(R.string.henry_ford_museum_number), R.drawable.henry_ford_museum, 42.300241, -83.233316));
        locations.add(new Locations(getString(R.string.greenfield_village), getString(R.string.greenfield_village_details), getString(R.string.greenfield_village_address),
                getString(R.string.greenfield_village_number), R.drawable.greenfield_village, 42.298279, -83.245248));
        locations.add(new Locations(getString(R.string.motown_museum), getString(R.string.motown_museum_details), getString(R.string.motown_museum_address),
                getString(R.string.motown_museum_number), R.drawable.motown_museum, 42.364082, -83.088352));
        locations.add(new Locations(getString(R.string.detroit_historical_museum), getString(R.string.detroit_historical_museum_details), getString(R.string.detroit_historical_museum_address),
                getString(R.string.detroit_historical_museum_number), R.drawable.detroit_historical_museum, 42.359765, -83.067208));
        locations.add(new Locations(getString(R.string.african_american_history_museum), getString(R.string.african_american_history_museum_details), getString(R.string.african_american_history_museum_address),
                getString(R.string.african_american_history_museum_number), R.drawable.museum_of_african_american_history, 42.359082, -83.061136));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
        final ListView listView = (ListView)rootView.findViewById(R.id.list);
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
