package com.namankhurpia.retrofit_movies_post_app_udemy.Service;

import com.namankhurpia.retrofit_movies_post_app_udemy.Model.MoviesDBResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataService {

    @GET("movie/popular")
    Call<MoviesDBResponse> getPopularMovies(@Query("api_key")String apikey);

}
