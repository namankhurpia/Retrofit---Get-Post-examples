package com.namankhurpia.retrofit_post_app_udemy.service;

import com.namankhurpia.retrofit_post_app_udemy.model.user;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostAppService {

    @POST("posts")
    Call<user> getResult(@Body user user);

}
