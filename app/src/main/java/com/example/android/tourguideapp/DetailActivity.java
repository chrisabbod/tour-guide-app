package com.example.android.tourguideapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity{
    private String stringExtra;
    private int intExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        //Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);

        //Create an adapter that knows which fragment should be shown on each page
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, getSupportFragmentManager());

        //Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.detail_fragment_container, new DetailFragment())
//                .commit();

//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.detail_fragment_container, new com.example.android.tourguideapp.MapFragment())
//                .commit();

    }
}