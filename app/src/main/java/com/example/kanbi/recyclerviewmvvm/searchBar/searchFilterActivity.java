package com.example.kanbi.recyclerviewmvvm.searchBar;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.kanbi.recyclerviewmvvm.R;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.hotelAdapter;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.hotelDataSet;
import com.example.kanbi.recyclerviewmvvm.inspirationBooking.inspirationHotel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class searchFilterActivity extends AppCompatActivity implements searchAdapter.OnClickListener{
    private RecyclerView mRecyclerView;
    private searchAdapter mAdapter;
    private ArrayList<searchModel> list;
    private SearchView searchView;
    private SearchView.SearchAutoComplete   searchAutoComplete;
    private ArrayList<String> itemlist;

    //private static final String URL_Data="https://api.myjson.com/bins/uvo9r";

    private static final String URL_Data="https://api.myjson.com/bins/tq8u3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_filter);

        mRecyclerView = (RecyclerView) findViewById(R.id.searchRecyclerview);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        list=new ArrayList<>();
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
                            JSONArray array=jsonObject.getJSONArray("hotelBooking");

                            for (int i=0;i<array.length();i++){
                                JSONObject jo=array.getJSONObject(i);
                                searchModel item=new searchModel(jo.getString("hotelName"),
                                        jo.getString("hotelType"),
                                        jo.getString("hotelImgURL"),jo.getString("hotelDetails"),jo.getString("hotelWebURL"));
                                list.add(item);
                            }
                            mAdapter=new searchAdapter(list,searchFilterActivity.this);
                            mRecyclerView.setAdapter(mAdapter);





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
    public void onItemClick(searchModel itemClicked) {
        itemClicked.getWebURL();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(itemClicked.getWebURL()));
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the options menu from XML
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);

        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();

        //autocomplete for searchview
        searchAutoComplete = (SearchView.SearchAutoComplete)     searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);

        searchAutoComplete.setDropDownBackgroundResource(R.drawable.color_cursor_white);
       // searchAutoComplete.setDropDownAnchor(R.id.action_search);
      //  searchAutoComplete.setThreshold(2);

        itemlist= new ArrayList<String>();
        itemlist.add("hotel");
        itemlist.add("flight");
        itemlist.add("summer");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, itemlist);
        searchAutoComplete.setAdapter(adapter);

        searchAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                // TODO Auto-generated method stub

                String searchString=(String)parent.getItemAtPosition(position);
                searchAutoComplete.setText(""+searchString);
                Toast.makeText(searchFilterActivity.this, "you clicked "+searchString, Toast.LENGTH_LONG).show();

            }
        });

        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default


        // searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return true;

            }


    });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

}
