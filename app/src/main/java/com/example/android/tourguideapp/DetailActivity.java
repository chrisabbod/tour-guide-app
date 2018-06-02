package com.example.android.tourguideapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    private String stringExtra;
    private int intExtra;

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
                stringExtra = extras.getString("string_index");
                intExtra = extras.getInt("int_index");
            }
        }else{
            stringExtra = (String)savedInstanceState.getSerializable("string_index");  //Retrieves string extra after screen rotation
            intExtra = savedInstanceState.getInt("index");
        }//TODO: Keep information across rotation

        ImageView detailImageView = (ImageView)findViewById(R.id.detail_image_view);
        TextView detailTextView = (TextView)findViewById(R.id.detail_text_view);

        detailImageView.setImageResource(intExtra);
        detailTextView.setText(stringExtra);
        //Toast.makeText(DetailActivity.this, intExtra, Toast.LENGTH_SHORT).show();
    }
}