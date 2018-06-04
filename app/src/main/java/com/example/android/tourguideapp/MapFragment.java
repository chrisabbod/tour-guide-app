package com.example.android.tourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback{
    private String titleExtra;
    private Double intLatitudeExtra, intLongitudeExtra;


    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        //If there is no savedInstanceState (Because we just arrived at this activity from the main activity) retrieve the string extra
        if(savedInstanceState == null){
            Bundle extras = getActivity().getIntent().getExtras();
            if(extras == null){
                titleExtra = null;
                intLatitudeExtra = null;
                intLongitudeExtra = null;
            }else{
                titleExtra = extras.getString("string_title_key");
                intLatitudeExtra = extras.getDouble("latitude_index");
                intLongitudeExtra = extras.getDouble("longitude_index");
            }
        }else{
            intLatitudeExtra = savedInstanceState.getDouble("latitude_index"); //Retrieves string extra after screen rotation
            intLongitudeExtra = savedInstanceState.getDouble("longitude_index");
        }

        initMap();

        return rootView;
    }

    private void initMap(){
        SupportMapFragment fragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map){
        LatLng latLng = new LatLng(intLatitudeExtra,intLongitudeExtra);
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18.0f));
        map.addMarker(new MarkerOptions().position(latLng).title(titleExtra));
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
}
