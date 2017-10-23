package com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.kanbi.recyclerviewmvvm.R;


public class MarFragment extends Fragment {

    private static final String TAG="MarFragment";
    private Button btnTest;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  @Nullable ViewGroup container, @Nullable
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_mar, container, false);
        btnTest=(Button) view.findViewById(R.id.btnTest);

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"tab for Mar",Toast.LENGTH_SHORT).show();
            }
        });



        return view;

    }


}
