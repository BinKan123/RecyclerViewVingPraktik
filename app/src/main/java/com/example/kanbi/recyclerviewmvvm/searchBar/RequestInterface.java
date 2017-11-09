package com.example.kanbi.recyclerviewmvvm.searchBar;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kanbi on 08/11/2017.
 */

public interface RequestInterface {

    @GET("search/jsonsearch")
    Call<JSONResponse> getJSON();



}
