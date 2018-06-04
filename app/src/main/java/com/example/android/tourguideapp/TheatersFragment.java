package com.example.android.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TheatersFragment extends Fragment {
    private static final String STRING_TITLE_KEY = "string_title_index";    //Key index used to pass location title to detail activity
    private static final String IMAGE_RESOURCE_KEY = "image_resource_index";    //Key index used to pass location image resource file

    public TheatersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Locations> locations = new ArrayList<>();
        locations.add(new Locations(getString(R.string.detroit_opera_house), R.drawable.detroit_opera_house));
        locations.add(new Locations(getString(R.string.redford_theatre), R.drawable.the_redford_theatre));
        locations.add(new Locations(getString(R.string.sound_board), R.drawable.sound_board_theater));
        locations.add(new Locations(getString(R.string.masonic_temple), R.drawable.masonic_temple_theater));
        locations.add(new Locations(getString(R.string.repertory_theatre), R.drawable.detroit_repertory_theatre));
        locations.add(new Locations(getString(R.string.senate_theater), R.drawable.senate_theater));
        locations.add(new Locations(getString(R.string.fox_theatre), R.drawable.fox_theatre));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
        ListView listView = (ListView)rootView.findViewById(R.id.list);
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
