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
public class HotelsFragment extends Fragment {
    private static final String STRING_TITLE_KEY = "string_title_index";    //Key index used to pass location title to detail activity
    private static final String IMAGE_RESOURCE_KEY = "image_resource_index";    //Key index used to pass location image resource file

    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Locations> locations = new ArrayList<>();
        locations.add(new Locations(getString(R.string.aloft_hotel), R.drawable.aloft_detroit));
        locations.add(new Locations(getString(R.string.mgm_grand_hotel), R.drawable.mgm_grand_hotel));
        locations.add(new Locations(getString(R.string.westin_hotel), R.drawable.westin_book_cadillac));
        locations.add(new Locations(getString(R.string.inn_on_ferry_street), R.drawable.inn_on_ferry_street));
        locations.add(new Locations(getString(R.string.crowne_plaza_hotel), R.drawable.crowne_plaza_hotel));
        locations.add(new Locations(getString(R.string.doubletree_suites), R.drawable.double_tree_suites));
        locations.add(new Locations(getString(R.string.holiday_inn), R.drawable.holiday_inn_express));
        locations.add(new Locations(getString(R.string.red_roof_inn), R.drawable.red_roof_inn));
        locations.add(new Locations(getString(R.string.comfort_inn), R.drawable.comfort_inn_greenfield));

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
