package com.example.kanbi.recyclerviewmvvm.inspirationBooking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

/**
 * Created by kanbi on 15/10/2017.
 */

public class inspirationHotel  extends AppCompatActivity implements hotelAdapter.ButtonClickListner {

    private static final String URL_Data="https://api.myjson.com/bins/12lj49";

    private RecyclerView recyclerView;
    private hotelAdapter adapter;
    private ArrayList<hotelDataSet> hotelData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inspirationhotel);
        recyclerView=(RecyclerView) findViewById(R.id.hotelrecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        hotelData=new ArrayList<>();

        loadRecyclerViewData();





    }
    private  void loadRecyclerViewData(){
        final ProgressDialog progressDialog=new ProgressDialog(this);
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
                            JSONArray array=jsonObject.getJSONArray("hotelItem");

                            for (int i=0;i<array.length();i++){
                                JSONObject jo=array.getJSONObject(i);
                                hotelDataSet item=new hotelDataSet(jo.getString("Group"),jo.getString("Type"),jo.getString("photosURL"),jo.getString("newURL"),jo.getString("Details"));
                                hotelData.add(item);
                            }
                            adapter=new hotelAdapter(hotelData, inspirationHotel.this);
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
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);



    }


    @Override
    public void btnClick(hotelDataSet itemClicked) {
        itemClicked.getNewURL();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(itemClicked.getNewURL()));
        startActivity(intent);
    }
}

