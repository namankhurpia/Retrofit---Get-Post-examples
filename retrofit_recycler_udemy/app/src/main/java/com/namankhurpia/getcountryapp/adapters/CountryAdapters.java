package com.namankhurpia.getcountryapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.namankhurpia.getcountryapp.R;
import com.namankhurpia.getcountryapp.model.Result;

import java.util.ArrayList;

public class CountryAdapters extends RecyclerView.Adapter<CountryAdapters.countryViewHolder>{

    private ArrayList<Result> countrieslist;

    //create a constructor to initialize the list with some value to avoid null pointer exception
    public CountryAdapters(ArrayList<Result> countrieslist) {
        this.countrieslist = countrieslist;
    }







    /**
     self generating method
     */
    @NonNull
    @Override
    public countryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.row_country,parent,false);


        return new countryViewHolder(view);
    }

    /**
     self generating method
     */
    @Override
    public void onBindViewHolder(@NonNull countryViewHolder holder, int position) {

        holder.countryNameTextView.setText(countrieslist.get(position).getName());

    }

    /**
     self generating method
     */
    @Override
    public int getItemCount() {
        return countrieslist.size();
    }








    //now we need to define an inner class to bind the elements in our view .... in our case we have only one text view...create a constructor as well
    class countryViewHolder extends RecyclerView.ViewHolder
    {
        TextView countryNameTextView;

        public countryViewHolder(View itemView) {
            super(itemView);

            countryNameTextView=itemView.findViewById(R.id.country_name_tv);
        }





    }

}
