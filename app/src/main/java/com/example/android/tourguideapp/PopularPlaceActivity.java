package com.example.android.tourguideapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class PopularPlaceActivity extends AppCompatActivity {
    private String stringExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        //If there is no savedInstanceState (Because we just arrived at this activity from the main activity) retrieve the string extra
        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                stringExtra = null;
            }else{
                stringExtra = extras.getString("index");
            }
        }else{
            stringExtra = (String)savedInstanceState.getSerializable("index");  //Retrieves string extra after screen rotation
        }

        TextView detailTextView = (TextView)findViewById(R.id.detail_text_view);
        detailTextView.setText(stringExtra);
    }
}