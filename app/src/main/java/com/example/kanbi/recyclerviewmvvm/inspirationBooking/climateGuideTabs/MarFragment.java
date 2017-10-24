package com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.JanRecyclerView.climateAdapter;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.JanRecyclerView.climateData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MarFragment extends Fragment implements climateAdapter.OnClickListener{

    private static final String TAG="MarFragment";
    private static final String URL_Data="https://api.myjson.com/bins/1cslpj";

    private RecyclerView recyclerView;
    private climateAdapter adapter;
    private ArrayList<com.example.kanbi.recyclerviewmvvm.inspirationBooking.climateGuideTabs.JanRecyclerView.climateData> climateData;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  @Nullable ViewGroup container, @Nullable
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_mar, container, false);

        recyclerView=(RecyclerView) view.findViewById(R.id.climateRecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        climateData=new ArrayList<>();

        loadRecyclerViewData();



        return view;

    }

    private  void loadRecyclerViewData(){
        final ProgressDialog progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading data...");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.GET,
                URL_Data,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array=jsonObject.getJSONArray("climateItem");

                            for (int i=0;i<array.length();i++){
                                JSONObject jo=array.getJSONObject(i);
                                climateData item=new climateData(jo.getString("Destination"),jo.getString("SunHrs"),jo.getString("WaterTemp"),jo.getString("HighTemp"),jo.getString("LowTemp"),jo.getString("newURL"));
                                climateData.add(item);


                            }
                            adapter=new climateAdapter(climateData, MarFragment.this);
                            recyclerView.setAdapter(adapter);

                        }catch(JSONException e){
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                    }
                });
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);

    }

    @Override
    public void onItemClick(climateData itemClicked) {
        itemClicked.getNewURL();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(itemClicked.getNewURL()));
        startActivity(intent);
    }



}
