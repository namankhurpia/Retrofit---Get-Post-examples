package com.namankhurpia.retrofit_movies_post_app_udemy.view;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.namankhurpia.retrofit_movies_post_app_udemy.Model.Movies;
import com.namankhurpia.retrofit_movies_post_app_udemy.R;

public class MovieActivity extends AppCompatActivity {

    private Movies movies;
    private ImageView movieposter;
    private String image;

    private TextView movieTitle, movieSynopsis, movieRating, movieReleaseDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//FLOATING BUTTON CODE
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//STARTING FROM HERE


        movieposter=(ImageView)findViewById(R.id.ivMoviewLarge);
        movieTitle = (TextView) findViewById(R.id.tvMovieTitle);
        movieSynopsis = (TextView) findViewById(R.id.tvPlotsynopsis);
        movieRating = (TextView) findViewById(R.id.tvMovieRating);
        movieReleaseDate = (TextView) findViewById(R.id.tvReleaseDate);




        Intent intent=getIntent();

        if(intent.hasExtra("movienamesending"))
        {
            movies=getIntent().getParcelableExtra("movienamesending");
            Toast.makeText(getApplicationContext(),movies.getOriginalTitle(),Toast.LENGTH_SHORT).show();

            //we need to get the name of movie,,, we'll get it from path
            image=movies.getPosterPath();

            String path="https://image.tmdb.org/t/p/w500"+image;

            RequestOptions requestOptions = new RequestOptions();
            Glide.with(this)
                    .load(path)
                    .apply(new RequestOptions().placeholder(R.drawable.loading).error(R.drawable.error))
                    .into(movieposter);


            getSupportActionBar().setTitle(movies.getTitle());
            movieTitle.setText(movies.getTitle());
            movieSynopsis.setText(movies.getOverview());
            movieRating.setText(Double.toString(movies.getVoteAverage()));
            movieReleaseDate.setText(movies.getReleaseDate());


        }






    }

}
