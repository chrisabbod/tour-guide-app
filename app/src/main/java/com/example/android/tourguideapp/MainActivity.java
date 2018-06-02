package com.example.android.tourguideapp;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Locations> locations = new ArrayList<>();
        locations.add(new Locations("Fort Wayne"));
        locations.add(new Locations("Pewabic Pottery"));
        locations.add(new Locations("GM Renaissance Center"));
        locations.add(new Locations("Henry Ford Estate"));
        locations.add(new Locations("Comerica Park"));
        locations.add(new Locations("Detroit Public Library"));
        locations.add(new Locations("Greektown"));

        LocationAdapter adapter = new LocationAdapter(MainActivity.this, locations);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
