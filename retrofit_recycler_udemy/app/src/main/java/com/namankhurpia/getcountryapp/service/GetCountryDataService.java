package com.namankhurpia.getcountryapp.service;

import com.namankhurpia.getcountryapp.model.Parent;

import retrofit2.Call;


import retrofit2.http.GET;

public interface GetCountryDataService {

    @GET("country/get/all")
    Call<Parent> GetResults();


}
