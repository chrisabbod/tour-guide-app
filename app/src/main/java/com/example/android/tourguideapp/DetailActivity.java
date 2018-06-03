package com.example.android.tourguideapp;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback{
    private String stringExtra;
    private int intExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.detail_fragment_container, new DetailFragment())
//                .commit();

        initMap();
    }

    //Initialize and inflate map fragment
    private void initMap(){
        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.detail_fragment_container);
        mapFragment.getMapAsync(this);
    }

    //When map fragment is ready apply marker and move to location
    @Override
    public void onMapReady(GoogleMap map){
        LatLng latLng = new LatLng(42.358750,-82.929737);
        map.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        map.addMarker(new MarkerOptions().position(latLng).title("Raj Amal"));
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
}