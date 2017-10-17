package com.example.kanbi.recyclerviewmvvm.sistaMinuten;

import android.content.Intent;
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

public class SistaMinFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.sistamin_fragment,container,false);
        Button searchSistaBtn = (Button) view.findViewById(R.id.searchSista);

        searchSistaBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), sistaMinuteActivity.class);
                getActivity().startActivity(intent);
            }

        });


        return view;
   
   
   
   
    }
    
    
    
    
    
    
}
