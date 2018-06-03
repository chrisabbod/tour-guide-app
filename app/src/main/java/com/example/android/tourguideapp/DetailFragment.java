package com.example.android.tourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    private String stringExtra;
    private int intExtra;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        //TODO: When returning to main activity go back to correct list (park, museum, etc.)
        //If there is no savedInstanceState (Because we just arrived at this activity from the main activity) retrieve the string extra
        if(savedInstanceState == null){
            Bundle extras = getActivity().getIntent().getExtras();
            if(extras == null){
                stringExtra = null;
            }else{
                stringExtra = extras.getString("string_title_index");
                intExtra = extras.getInt("image_resource_index");
            }
        }else{
            stringExtra = (String)savedInstanceState.getSerializable("string_title_index");  //Retrieves string extra after screen rotation
            intExtra = savedInstanceState.getInt("image_resource_index");
        }//TODO: Keep information across rotation


        ImageView detailImageView = (ImageView) rootView.findViewById(R.id.detail_image_view);
        TextView detailTextView = (TextView)rootView.findViewById(R.id.detail_text_view);

        detailImageView.setImageResource(intExtra);
        detailTextView.setText(stringExtra);

        return rootView;
    }

    public void onResume(){
        super.onResume();

        //Set title bar
        (getActivity()).setTitle(stringExtra);
    }

}
