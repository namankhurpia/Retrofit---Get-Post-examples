package com.namankhurpia.retrofit_movies_post_app_udemy.view;

import android.content.res.Configuration;
import android.graphics.Movie;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.namankhurpia.retrofit_movies_post_app_udemy.Adapter.MovieAdapter;
import com.namankhurpia.retrofit_movies_post_app_udemy.Model.Movies;
import com.namankhurpia.retrofit_movies_post_app_udemy.R;
import com.namankhurpia.retrofit_movies_post_app_udemy.Model.MoviesDBResponse;
import com.namankhurpia.retrofit_movies_post_app_udemy.Service.MovieDataService;
import com.namankhurpia.retrofit_movies_post_app_udemy.Service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Movies> movies;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;

    //for swipe to refresh
    private SwipeRefreshLayout swipetorefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        getSupportActionBar().setTitle("TMDB Popular Movies Today");

        getPopularMovies();




        swipetorefresh=(SwipeRefreshLayout)findViewById(R.id.swipeToRefresh);
        swipetorefresh.setColorSchemeResources(R.color.colorPrimary);
        swipetorefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                getPopularMovies();

            }
        });




    }

    public void getPopularMovies() {

        final MovieDataService movieDataService=RetrofitInstance.getService();
        Call<MoviesDBResponse> call=movieDataService.getPopularMovies(this.getString(R.string.api_key));

        call.enqueue(new Callback<MoviesDBResponse>() {
            @Override
            public void onResponse(Call<MoviesDBResponse> call, Response<MoviesDBResponse> response) {
                MoviesDBResponse moviesDBResponse=response.body();

                if(moviesDBResponse!=null && moviesDBResponse.getMovies()!=null)
                {
                    movies=(ArrayList<Movies>) moviesDBResponse.getMovies();
                    showOnRecyclerView();
                }

            }

            @Override
            public void onFailure(Call<MoviesDBResponse> call, Throwable t) {

            }
        });



    }

    private void showOnRecyclerView() {
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);

        movieAdapter=new MovieAdapter(this,movies);

        if(this.getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT)
        {
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        }
        else
        {
            recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        }

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);
        movieAdapter.notifyDataSetChanged();




    }
}
