package com.namankhurpia.retrofit_single_value_udemy.service;



import com.namankhurpia.retrofit_single_value_udemy.model.Parent;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetCountryDataService {

    @GET("/country/get/iso2code/{alpha2_code}")
    Call<Parent> GetResultsByAlpha2Code(@Path("alpha2_code")String alpha2code);


}
