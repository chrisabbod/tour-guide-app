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
public class TheaterFragment extends Fragment {
    private static final String STRING_TITLE_KEY = "string_title_index";    //Key index used to pass location title to detail activity
    private static final String STRING_DETAILS_KEY = "string_details_index";
    private static final String STRING_ADDRESS_KEY = "string_address_index";
    private static final String STRING_PHONE_KEY = "string_phone_index";
    private static final String IMAGE_RESOURCE_KEY = "image_resource_index";    //Key index used to pass location image resource file
    private static final String LATITUDE_KEY = "latitude_index";
    private static final String LONGITUDE_KEY = "longitude_index";

    public TheaterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(getString(R.string.detroit_opera_house), getString(R.string.detroit_opera_house_details), getString(R.string.detroit_opera_house_address),
                getString(R.string.detroit_opera_house_number), R.drawable.detroit_opera_house, 42.336586, -83.048849));
        locations.add(new Location(getString(R.string.redford_theatre), getString(R.string.redford_theatre_details), getString(R.string.redford_theatre_address),
                getString(R.string.redford_theatre_number), R.drawable.the_redford_theatre, 42.417406, -83.257208));
        locations.add(new Location(getString(R.string.sound_board), getString(R.string.sound_board_details), getString(R.string.sound_board_address),
                getString(R.string.sound_board_number), R.drawable.sound_board_theater, 42.339324, -83.067158));
        locations.add(new Location(getString(R.string.masonic_temple), getString(R.string.masonic_temple_details), getString(R.string.masonic_temple_address),
                getString(R.string.masonic_temple_number), R.drawable.masonic_temple_theater, 42.341881, -83.059797));
        locations.add(new Location(getString(R.string.repertory_theatre), getString(R.string.repertory_theatre_details), getString(R.string.repertory_theatre_address),
                getString(R.string.repertory_theatre_number), R.drawable.detroit_repertory_theatre, 42.395135, -83.109813));
        locations.add(new Location(getString(R.string.senate_theater), getString(R.string.senate_theater_details), getString(R.string.senate_theater_address),
                getString(R.string.senate_theater_number), R.drawable.senate_theater, 42.331417, -83.122873));
        locations.add(new Location(getString(R.string.fox_theatre), getString(R.string.fox_theatre_details), getString(R.string.fox_theatre_address),
                getString(R.string.fox_theatre_number), R.drawable.fox_theatre, 42.338310, -83.052666));

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
