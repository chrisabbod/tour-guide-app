package com.example.android.tourguideapp;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_INDEX = "index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Locations> locations = new ArrayList<>();
        locations.add(new Locations("Fort Wayne", R.drawable.fort_wayne));
        locations.add(new Locations("Pewabic Pottery", R.drawable.pewabic_pottery));
        locations.add(new Locations("GM Renaissance Center", R.drawable.renaissance_center));
        locations.add(new Locations("Henry Ford Estate", R.drawable.henry_ford_estate));
        locations.add(new Locations("Comerica Park", R.drawable.comerica_park));
        locations.add(new Locations("Detroit Public Library", R.drawable.detroit_public_library));
        locations.add(new Locations("Greektown", R.drawable.greektown));

        LocationAdapter adapter = new LocationAdapter(MainActivity.this, locations);
        final ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this, PopularPlaceActivity.class);
                intent.putExtra(KEY_INDEX, locations.get(position).getLocationName());  //Retrieve location title from selected item and pass to detail activity
                intent.putExtra(KEY_INDEX, locations.get(position).getImageResource()); //Pass image resource to detail activity so image can be displayed//Toast.makeText(MainActivity.this, locations.get(position).getImageResource(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}
