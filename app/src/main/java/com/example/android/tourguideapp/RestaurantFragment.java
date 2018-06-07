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
public class RestaurantFragment extends Fragment {
    private static final String STRING_TITLE_KEY = "string_title_index";    //Key index used to pass location title to detail activity
    private static final String STRING_DETAILS_KEY = "string_details_index";
    private static final String STRING_ADDRESS_KEY = "string_address_index";
    private static final String STRING_PHONE_KEY = "string_phone_index";
    private static final String IMAGE_RESOURCE_KEY = "image_resource_index";    //Key index used to pass location image resource file
    private static final String LATITUDE_KEY = "latitude_index";
    private static final String LONGITUDE_KEY = "longitude_index";

    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(getString(R.string.giovanni), getString(R.string.giovanni_details), getString(R.string.giovanni_address),
                getString(R.string.giovanni_number), R.drawable.giovanni_restaurant, 42.290216, -83.146264));
        locations.add(new Location(getString(R.string.chartreuse), getString(R.string.chartreuse_details), getString(R.string.chartreuse_address),
                getString(R.string.chartreuse_number), R.drawable.chartreuse_restaurant, 42.360504, -83.066030));
        locations.add(new Location(getString(R.string.supino), getString(R.string.supino_details), getString(R.string.supino_address),
                getString(R.string.supino_number), R.drawable.supino_pizzeria, 42.345365, -83.040249));
        locations.add(new Location(getString(R.string.selden_standard), getString(R.string.selden_standard_details), getString(R.string.selden_standard_address),
                getString(R.string.selden_standard_number), R.drawable.selden_standard_restaurant, 42.347802, -83.064976));
        locations.add(new Location(getString(R.string.buddy_pizza), getString(R.string.buddy_pizza_details), getString(R.string.buddy_pizza_address),
                getString(R.string.buddy_pizza_number), R.drawable.buddy_pizza, 42.418936, -83.064127));
        locations.add(new Location(getString(R.string.wright_company), getString(R.string.wright_company_details), getString(R.string.wright_company_address),
                getString(R.string.wright_company_number), R.drawable.wright_and_company_restaurant, 42.335205, -83.049117));
        locations.add(new Location(getString(R.string.mudgies), getString(R.string.mudgies_details), getString(R.string.mudgies_address),
                getString(R.string.mudgies_number), R.drawable.mudgies_restaurant, 42.329059, -83.062040));
        locations.add(new Location(getString(R.string.lafayette_coney_island), getString(R.string.lafayette_coney_island_details), getString(R.string.lafayette_coney_island_address),
                getString(R.string.lafayette_coney_island_number), R.drawable.lafayette_coney_island, 42.331510, -83.048786));
        locations.add(new Location(getString(R.string.vicente), getString(R.string.vicente_details), getString(R.string.vicente_address),
                getString(R.string.vicente_number), R.drawable.vicente_cuban_cuisine, 42.334626, -83.046835));

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
