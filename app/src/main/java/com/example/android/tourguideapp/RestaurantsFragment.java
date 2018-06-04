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
public class RestaurantsFragment extends Fragment {
    private static final String STRING_TITLE_KEY = "string_title_index";    //Key index used to pass location title to detail activity
    private static final String IMAGE_RESOURCE_KEY = "image_resource_index";    //Key index used to pass location image resource file

    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Locations> locations = new ArrayList<>();
        locations.add(new Locations(getString(R.string.giovanni), R.drawable.giovanni_restaurant));
        locations.add(new Locations(getString(R.string.chartreuse), R.drawable.chartreuse_restaurant));
        locations.add(new Locations(getString(R.string.supino), R.drawable.supino_pizzeria));
        locations.add(new Locations(getString(R.string.selden_standard), R.drawable.selden_standard_restaurant));
        locations.add(new Locations(getString(R.string.buddy_pizza), R.drawable.buddy_pizza));
        locations.add(new Locations(getString(R.string.wright_company), R.drawable.wright_and_company_restaurant));
        locations.add(new Locations(getString(R.string.mudgies), R.drawable.mudgies_restaurant));
        locations.add(new Locations(getString(R.string.lafayette_coney_island), R.drawable.lafayette_coney_island));
        locations.add(new Locations(getString(R.string.vicente), R.drawable.vicente_cuban_cuisine));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
        final ListView listView = (ListView)rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(STRING_TITLE_KEY, locations.get(position).getLocationName());  //Retrieve location title from selected item and pass to detail activity
                intent.putExtra(IMAGE_RESOURCE_KEY, locations.get(position).getImageResource()); //Pass image resource to detail activity so image can be displayed//Toast.makeText(MainActivity.this, locations.get(position).getImageResource(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        return rootView;
    }

}
