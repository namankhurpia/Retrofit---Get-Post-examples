package com.namankhurpia.retrofit_movies_post_app_udemy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.namankhurpia.retrofit_movies_post_app_udemy.Model.Movies;
import com.namankhurpia.retrofit_movies_post_app_udemy.R;
import com.namankhurpia.retrofit_movies_post_app_udemy.view.MovieActivity;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    private Context context;
    private ArrayList<Movies> moviesArrayList;

    //step1-creating constructor to initalize and avoid null pointer exceptions
    public MovieAdapter(Context context, ArrayList<Movies> moviesArrayList) {
        this.context = context;
        this.moviesArrayList = moviesArrayList;
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder
    {
        //define item in one view
        public TextView movietitle,rate;
        public ImageView movieimage;

        //automatically created constructor for viewholder
        public MovieViewHolder(View itemView) {
            super(itemView);

            //bind the items with the view
            movieimage=(ImageView)itemView.findViewById(R.id.ivMovie);
            movietitle=(TextView)itemView.findViewById(R.id.tvtitle);
            rate=(TextView)itemView.findViewById(R.id.tvRating);



            //for next page
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //we need to implement a click on item such that when we click it sends the object through an intent and to do so we have to make objects parselable, we did that while makeing model class

                    //to get the current posotion of the adapter
                    int position=getAdapterPosition();

                    //we can get the selected movies object(insatance) via the array list implemented
                    //if selected position is not clear it can cause null pointer exception
                    if (position!=RecyclerView.NO_POSITION)
                    {
                        Movies selectedmovie=moviesArrayList.get(position);
                        Intent intent=new Intent(context, MovieActivity.class);
                        intent.putExtra("movienamesending",selectedmovie);
                        context.startActivity(intent);
                    }


                }
            });


        }
    }






    /*automatically generated  step2*/
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.movielistitem,parent,false);

        return new MovieViewHolder(view);

    }

    /*automatically generated  step3  we use in to posotion the correct name in the textview*/
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        holder.movietitle.setText(moviesArrayList.get(position).getOriginalTitle());

        holder.rate.setText(Double.toString(moviesArrayList.get(position).getVoteAverage()));

        String imagepath="https://image.tmdb.org/t/p/w500"+moviesArrayList.get(position).getPosterPath();

        RequestOptions requestOptions = new RequestOptions();
        Glide.with(context)
                .load(imagepath)
                .apply(new RequestOptions().placeholder(R.drawable.loading).error(R.drawable.error))
                .into(holder.movieimage);




    }

    /*automatically generated   step1*/
    @Override
    public int getItemCount() {
        return moviesArrayList.size();
    }

}
