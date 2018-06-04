package com.example.android.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {
    private static final String STRING_TITLE_KEY = "string_title_index";    //Key index used to pass location title to detail activity
    private static final String STRING_DETAILS_KEY = "string_details_index";
    private static final String STRING_ADDRESS_KEY = "string_address_index";
    private static final String STRING_PHONE_KEY = "string_phone_index";
    private static final String IMAGE_RESOURCE_KEY = "image_resource_index";    //Key index used to pass location image resource file
    private static final String LATITUDE_KEY = "latitude_index";
    private static final String LONGITUDE_KEY = "longitude_index";

    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Locations> locations = new ArrayList<>();
        locations.add(new Locations(getString(R.string.aloft_hotel), getString(R.string.aloft_hotel_details), getString(R.string.aloft_hotel_address),
                getString(R.string.aloft_hotel_number), R.drawable.aloft_detroit, 42.335616, -83.050527));
        locations.add(new Locations(getString(R.string.mgm_grand_hotel), getString(R.string.mgm_grand_hotel_details), getString(R.string.mgm_grand_hotel_address),
                getString(R.string.mgm_grand_hotel_number), R.drawable.mgm_grand_hotel, 42.333070, -83.059559));
        locations.add(new Locations(getString(R.string.westin_hotel), getString(R.string.westin_hotel_details), getString(R.string.westin_hotel_address),
                getString(R.string.westin_hotel_number), R.drawable.westin_book_cadillac, 42.331983, -83.050359));
        locations.add(new Locations(getString(R.string.inn_on_ferry_street), getString(R.string.inn_on_ferry_street_details), getString(R.string.inn_on_ferry_street_address),
                getString(R.string.inn_on_ferry_street_number), R.drawable.inn_on_ferry_street, 42.361500, -83.065600));
        locations.add(new Locations(getString(R.string.crowne_plaza_hotel), getString(R.string.crowne_plaza_hotel_details), getString(R.string.crowne_plaza_hotel_address),
                getString(R.string.crowne_plaza_hotel_number), R.drawable.crowne_plaza_hotel, 42.327908, -83.047800));
        locations.add(new Locations(getString(R.string.doubletree_suites), getString(R.string.doubletree_suites_details), getString(R.string.doubletree_suites_address),
                getString(R.string.doubletree_suites_number), R.drawable.double_tree_suites, 42.329135, -83.052834));
        locations.add(new Locations(getString(R.string.holiday_inn), getString(R.string.holiday_inn_details), getString(R.string.holiday_inn_address),
                getString(R.string.holiday_inn_number), R.drawable.holiday_inn_express, 42.331287, -83.050485));
        locations.add(new Locations(getString(R.string.red_roof_inn), getString(R.string.red_roof_inn_details), getString(R.string.red_roof_inn_address),
                getString(R.string.red_roof_inn_number), R.drawable.red_roof_inn, 42.300151, -83.273806));
        locations.add(new Locations(getString(R.string.comfort_inn), getString(R.string.comfort_inn_details), getString(R.string.comfort_inn_address),
                getString(R.string.comfort_inn_number), R.drawable.comfort_inn_greenfield, 42.307568, -83.231905));

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
