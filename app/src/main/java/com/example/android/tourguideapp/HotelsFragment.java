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
        locations.add(new Locations("Aloft Detroit at The David Whitney", R.drawable.aloft_detroit));
        locations.add(new Locations("MGM Grand Detroit", R.drawable.mgm_grand_hotel));
        locations.add(new Locations("Westin Book Cadillac Hotel", R.drawable.westin_book_cadillac));
        locations.add(new Locations("The Inn on Ferry Street", R.drawable.inn_on_ferry_street));
        locations.add(new Locations("Crowne Plaza Hotel", R.drawable.crown_plaza_hotel));
        locations.add(new Locations("DoubleTree Suites", R.drawable.double_tree_suites));
        locations.add(new Locations("Holiday Inn Express & Suites Detroit Downtown", R.drawable.holiday_inn_express));
        locations.add(new Locations("Red Roof Inn Detroit", R.drawable.red_roof_inn));
        locations.add(new Locations("Comfort Inn Near Greenfield Village", R.drawable.comfort_inn_greenfield));

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
