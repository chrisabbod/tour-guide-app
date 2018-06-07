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
public class ParkFragment extends Fragment {
    private static final String STRING_TITLE_KEY = "string_title_index";    //Key index used to pass location title to detail activity
    private static final String STRING_DETAILS_KEY = "string_details_index";
    private static final String STRING_ADDRESS_KEY = "string_address_index";
    private static final String STRING_PHONE_KEY = "string_phone_index";
    private static final String IMAGE_RESOURCE_KEY = "image_resource_index";    //Key index used to pass location image resource file
    private static final String LATITUDE_KEY = "latitude_index";
    private static final String LONGITUDE_KEY = "longitude_index";

    public ParkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(getString(R.string.mariner_park), getString(R.string.mariner_park_details), getString(R.string.mariner_park_address),
                getString(R.string.mariner_park_number), R.drawable.mariner_park, 42.358750, -82.929737));
        locations.add(new Location(getString(R.string.west_riverfront_park), getString(R.string.west_riverfront_park_details), getString(R.string.west_riverfront_park_address),
                getString(R.string.west_riverfront_park_number), R.drawable.west_riverfront_park, 42.321885, -83.063066));
        locations.add(new Location(getString(R.string.grand_circus_park), getString(R.string.grand_circus_park_details), getString(R.string.grand_circus_park_address),
                getString(R.string.grand_circus_park_number), R.drawable.grand_circus_park, 42.328245, -83.049562));
        locations.add(new Location(getString(R.string.belle_isle), getString(R.string.belle_isle_details), getString(R.string.belle_isle_address),
                getString(R.string.belle_isle_number), R.drawable.belle_isle_park, 42.336514, -82.985275));
        locations.add(new Location(getString(R.string.detroit_zoo), getString(R.string.detroit_zoo_details), getString(R.string.detroit_zoo_address),
                getString(R.string.detroit_zoo_number), R.drawable.detroit_zoo, 42.476489, -83.150798));
        locations.add(new Location(getString(R.string.campus_martius_park), getString(R.string.campus_martius_park_details), getString(R.string.campus_martius_park_address),
                getString(R.string.campus_martius_park_number), R.drawable.campus_martius_park, 42.331563, -83.046835));
        locations.add(new Location(getString(R.string.state_park_harbor), getString(R.string.state_park_harbor_details), getString(R.string.state_park_harbor_address),
                getString(R.string.state_park_harbor_number), R.drawable.william_state_park, 42.333180, -83.025744));

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
