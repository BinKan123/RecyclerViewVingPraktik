package com.example.kanbi.recyclerviewmvvm.inspirationBooking;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.kanbi.recyclerviewmvvm.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.R.attr.fragment;

/**
 * Created by kanbi on 10/10/2017.
 */

public class InspirationFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.inspiration_fragment, container, false);



        //destination
        Button destinationButton = (Button) view.findViewById(R.id.destination);

        destinationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), destinationActivity.class);
                getActivity().startActivity(intent);
            }

        });

        //värmeguiden
        Button warmguidenButton = (Button) view.findViewById(R.id.warmguiden);

        warmguidenButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(),warminfoActivity .class);
                getActivity().startActivity(intent);
            }

        });


        //restips
        Button restipsButton = (Button) view.findViewById(R.id.restips);

        restipsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), restipsActivity.class);
                getActivity().startActivity(intent);
            }

        });


        //hotel
        Button hotelButton = (Button) view.findViewById(R.id.ourHotel);

        hotelButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), inspirationHotel.class);
                getActivity().startActivity(intent);
            }

        });


    return view;
    }


}


