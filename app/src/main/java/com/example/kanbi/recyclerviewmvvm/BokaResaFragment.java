package com.example.kanbi.recyclerviewmvvm;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kanbi on 10/10/2017.
 */

public class BokaResaFragment extends Fragment {
    public BokaResaFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.book_fragment,container,false);
    }
}

