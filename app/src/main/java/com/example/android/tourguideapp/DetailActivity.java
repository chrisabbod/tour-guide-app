package com.example.android.tourguideapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity{
    private String stringExtra;
    private int intExtra;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.detail_fragment_container, new DetailFragment())
//                .commit();

        //ViewPager and its adapters use support library
        //fragments, so use getSupportFragmentManager

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.detail_fragment_container, new com.example.android.tourguideapp.MapFragment())
                .commit();

    }
}