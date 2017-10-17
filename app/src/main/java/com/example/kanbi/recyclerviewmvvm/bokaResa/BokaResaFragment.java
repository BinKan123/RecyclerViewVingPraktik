package com.example.kanbi.recyclerviewmvvm.bokaResa;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kanbi.recyclerviewmvvm.R;

/**
 * Created by kanbi on 10/10/2017.
 */

public class BokaResaFragment extends Fragment {
    public BokaResaFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.book_fragment,container,false);

       //flyg+hotell
        Button flygHotellBtn = (Button) view.findViewById(R.id.destination);

        flygHotellBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), flygHotellWeb.class);
                getActivity().startActivity(intent);
            }

        });


        //city
        Button cityBtn = (Button) view.findViewById(R.id.warmguiden);

        cityBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), cityWeb.class);
                getActivity().startActivity(intent);
            }

        });


        //kryssning


        Button krysningBtn = (Button) view.findViewById(R.id.restips);

        krysningBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), kryssningWeb.class);
                getActivity().startActivity(intent);
            }

        });


        //flyg

        Button flygBtn = (Button) view.findViewById(R.id.flyg);

        flygBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), flygWeb.class);
                getActivity().startActivity(intent);
            }

        });

        //hotell
        Button hotellBtn = (Button) view.findViewById(R.id.hotell);

        hotellBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), hotellWeb.class);
                getActivity().startActivity(intent);
            }

        });


        return view;

    }
}

