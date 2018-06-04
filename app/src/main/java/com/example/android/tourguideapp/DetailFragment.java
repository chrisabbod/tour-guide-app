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
    private String stringExtraTitle, stringExtraDetails, stringExtraAddress, stringExtraPhone;
    private int intExtra;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);


        //If there is no savedInstanceState (Because we just arrived at this activity from the main activity) retrieve the string extra
        if(savedInstanceState == null){
            Bundle extras = getActivity().getIntent().getExtras();
            if(extras == null){
                stringExtraTitle = null;
                stringExtraDetails = null;
                stringExtraAddress = null;
                stringExtraPhone = null;
            }else{
                stringExtraTitle = extras.getString("string_title_index");
                stringExtraDetails = extras.getString("string_details_index");
                stringExtraAddress = extras.getString("string_address_index");
                stringExtraPhone = extras.getString("string_phone_index");
                intExtra = extras.getInt("image_resource_index");
            }
        }else{
            stringExtraTitle = (String)savedInstanceState.getSerializable("string_title_index");
            intExtra = savedInstanceState.getInt("image_resource_index");
        }


        ImageView detailImageView = rootView.findViewById(R.id.detail_image_view);
        TextView titleView = rootView.findViewById(R.id.title_text_view);
        TextView detailView = rootView.findViewById(R.id.detail_text_view);
        TextView addressView = rootView.findViewById(R.id.address_text_view);
        TextView phoneNumberView = rootView.findViewById(R.id.phone_number_text_view);

        detailImageView.setImageResource(intExtra);
        titleView.setText(stringExtraTitle);
        detailView.setText(stringExtraDetails);
        addressView.setText(stringExtraAddress);
        phoneNumberView.setText(stringExtraPhone);

        return rootView;
    }

    public void onResume(){
        super.onResume();

        //Set title bar
        (getActivity()).setTitle(stringExtraTitle);
    }

}
