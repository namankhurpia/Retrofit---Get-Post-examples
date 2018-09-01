package com.namankhurpia.getcountryapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.namankhurpia.getcountryapp.R;
import com.namankhurpia.getcountryapp.adapters.CountryAdapters;
import com.namankhurpia.getcountryapp.model.Parent;
import com.namankhurpia.getcountryapp.model.Result;
import com.namankhurpia.getcountryapp.service.GetCountryDataService;
import com.namankhurpia.getcountryapp.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Result> results;
    private CountryAdapters countryAdapters;
    private RecyclerView recyclerView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCountries();
    }

    public Object getCountries() {

        GetCountryDataService getCountryDataService= RetrofitInstance.GetServices();
        Call<Parent> call=getCountryDataService.GetResults();

        call.enqueue(new Callback<Parent>() {
            @Override
            public void onResponse(Call<Parent> call, Response<Parent> response) {

                Parent parent=response.body();

                if(parent!=null && parent.getRestResponse()!=null)
                {
                    results=(ArrayList<Result>)parent.getRestResponse().getResult();

                    for(Result r:results)
                    {
                        Log.i("Name","****************"+r.getName());//storing data in log *****no list view for now

                    }

                    viewData();


                }
            }

            @Override
            public void onFailure(Call<Parent> call, Throwable t) {


            }
        });

        return results;
    }







    private void viewData() {
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        countryAdapters=new CountryAdapters(results);

        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(countryAdapters);

    }
}
