package com.example.android.tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HotelsActivity extends AppCompatActivity {
    private static final String STRING_TITLE_KEY = "string_title_index";    //Key index used to pass location title to detail activity
    private static final String IMAGE_RESOURCE_KEY = "image_resource_index";    //Key index used to pass location image resource file

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        LocationAdapter adapter = new LocationAdapter(HotelsActivity.this, locations);
        final ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(HotelsActivity.this, DetailActivity.class);
                intent.putExtra(STRING_TITLE_KEY, locations.get(position).getLocationName());  //Retrieve location title from selected item and pass to detail activity
                intent.putExtra(IMAGE_RESOURCE_KEY, locations.get(position).getImageResource()); //Pass image resource to detail activity so image can be displayed//Toast.makeText(PopularPlacesActivity.this, locations.get(position).getImageResource(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}
