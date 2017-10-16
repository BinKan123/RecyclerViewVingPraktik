package com.example.kanbi.recyclerviewmvvm;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by kanbi on 10/10/2017.
 */

public class StartFragment extends Fragment {

    private static final String URL_Data="https://api.myjson.com/bins/1dynih";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<Data> listData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.start_fragment,container,false);
        recyclerView=(RecyclerView) rootView.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));


        listData=new ArrayList<>();
        loadRecyclerViewData();

        return rootView;

    }
    private  void loadRecyclerViewData(){
        final ProgressDialog progressDialog=new ProgressDialog(this.getActivity());
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
                            JSONArray array=jsonObject.getJSONArray("menuitem");

                            for (int i=0;i<array.length();i++){
                                JSONObject jo=array.getJSONObject(i);
                                Data item=new Data(jo.getString("title"),jo.getString("photosURL"),jo.getString("Details"));
                                listData.add(item);
                            }
                            adapter=new Adapter(listData, getActivity().getApplicationContext());
                            recyclerView.setAdapter(adapter);



                        }catch(JSONException e){
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity().getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();

                    }
                });
        RequestQueue requestQueue= Volley.newRequestQueue(this.getActivity());
        requestQueue.add(stringRequest);



    }

}


