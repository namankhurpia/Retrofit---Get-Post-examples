package com.namankhurpia.android_retrofit_get_ip.remote;

import com.namankhurpia.android_retrofit_get_ip.model.Ip;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Naman Khurpia on 11-05-2018.
 */

public interface ipService {

    @GET("/")
    Call<Ip>getIp();
}
