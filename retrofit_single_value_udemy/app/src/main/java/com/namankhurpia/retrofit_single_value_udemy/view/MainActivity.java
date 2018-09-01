package com.namankhurpia.retrofit_single_value_udemy.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.namankhurpia.retrofit_single_value_udemy.R;
import com.namankhurpia.retrofit_single_value_udemy.model.Parent;
import com.namankhurpia.retrofit_single_value_udemy.model.Result;
import com.namankhurpia.retrofit_single_value_udemy.service.GetCountryDataService;
import com.namankhurpia.retrofit_single_value_udemy.service.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText country_alpha2code;
    private Button submit,clear;
    private TextView countryname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        country_alpha2code=(EditText)findViewById(R.id.city_code_et);
        submit=(Button)findViewById(R.id.submit);
        clear=(Button)findViewById(R.id.clear);
        countryname=(TextView)findViewById(R.id.cityname_tv);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String alphac=country_alpha2code.getText().toString();


                GetCountryDataService getCountryDataService= RetrofitInstance.GetServices();

                Call<Parent> call=getCountryDataService.GetResultsByAlpha2Code(alphac);

                call.enqueue(new Callback<Parent>() {
                    @Override
                    public void onResponse(Call<Parent> call, Response<Parent> response) {

                        if (response != null && call!=null) {

                            Parent parent = response.body();
                            if (parent != null && parent.getRestResponse() != null) {

                                Result result = parent.getRestResponse().getResult();
                                if(result!=null)
                                {
                                    countryname.setText(result.getName());
                                }
                                else
                                {
                                    countryname.setText("Does not exist");
                                    Toast.makeText(getApplicationContext(),"Does not exist",Toast.LENGTH_SHORT).show();
                                }


                            } else {
                                countryname.setText("Does not exist");
                                Toast.makeText(getApplicationContext(),"Does not exist",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            countryname.setText("Does not exist");
                            Toast.makeText(getApplicationContext(),"Does not exist",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Parent> call, Throwable t) {
                        countryname.setText("Does not exist");

                    }
                });


            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                country_alpha2code.setText("");
                countryname.setText("");

            }
        });


    }
}
