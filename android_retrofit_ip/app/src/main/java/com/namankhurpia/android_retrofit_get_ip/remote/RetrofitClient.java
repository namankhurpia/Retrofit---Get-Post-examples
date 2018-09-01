package com.namankhurpia.android_retrofit_get_ip.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Naman Khurpia on 11-05-2018.
 */

public class RetrofitClient {

    private static Retrofit retrofit=null;

    public static Retrofit getClient(String baseurl)
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
