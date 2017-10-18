package com.example.kanbi.recyclerviewmvvm.minSida;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kanbi.recyclerviewmvvm.R;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.inspirationHotel;

/**
 * Created by kanbi on 10/10/2017.
 */

public class MinSidaFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.minsida_fragment,container,false);

        Button loginBtn = (Button) view.findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), LoginActivity.class);
                getActivity().startActivity(intent);
            }

        });

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        { @Override public void onClick(View v)
        {
            // do something
        }
        });
    return view;
}
}
