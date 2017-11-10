package com.example.kanbi.recyclerviewmvvm.searchBar;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

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

public class searchFilterActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private searchAdapter mAdapter;
    private ArrayList<searchModel> list;

    private static final String URL_Data="https://api.myjson.com/bins/uvo9r";

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
                            JSONArray array=jsonObject.getJSONArray("countryName");

                            for (int i=0;i<array.length();i++){
                                JSONObject jo=array.getJSONObject(i);
                                searchModel item=new searchModel(jo.getString("countryName"));
                                list.add(item);
                            }
                            mAdapter=new searchAdapter(list);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the options menu from XML
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);
       // MenuItem searchItem = menu.findItem(R.id.action_search);
        //final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default

       /* final List<String> suggestions = new ArrayList<>();

        final CursorAdapter suggestionAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                null,
                new String[]{SearchManager.SUGGEST_COLUMN_TEXT_1},
                new int[]{android.R.id.text1},
                0);

        searchView.setSuggestionsAdapter(suggestionAdapter);

        searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            @Override
            public boolean onSuggestionSelect(int position) {
                return false;
            }

            @Override
            public boolean onSuggestionClick(int position) {
                searchView.setQuery(suggestions.get(position), true);
                searchView.clearFocus();
                return true;
            }
        });
              */

        // searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                /* // Hit the network and take all the suggestions and store them in List 'suggestions'

                                 String[] columns = { BaseColumns._ID,
                                                         SearchManager.SUGGEST_COLUMN_TEXT_1,
                                                         SearchManager.SUGGEST_COLUMN_INTENT_DATA,
                                                     };
                                 MatrixCursor cursor = new MatrixCursor(columns);
                                 for (int i = 0; i < suggestions.size(); i++) {
                                     String[] tmp = {Integer.toString(i),suggestions.get(i),suggestions.get(i)};
                                     cursor.addRow(tmp);
                                 }
                                 suggestionAdapter.swapCursor(cursor);     */


                return true;

            }


    });
        //return true;
         return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

}
