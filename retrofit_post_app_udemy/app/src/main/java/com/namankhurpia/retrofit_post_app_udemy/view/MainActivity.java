package com.namankhurpia.retrofit_post_app_udemy.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.namankhurpia.retrofit_post_app_udemy.R;
import com.namankhurpia.retrofit_post_app_udemy.model.user;
import com.namankhurpia.retrofit_post_app_udemy.service.PostAppService;
import com.namankhurpia.retrofit_post_app_udemy.service.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText email_field;
    private EditText password_filed;
    private Button btn_submit;
    private TextView result_text_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email_field=(EditText)findViewById(R.id.email_field);
        password_filed=(EditText)findViewById(R.id.password_field);
        btn_submit=(Button)findViewById(R.id.btn_submit);
        result_text_view=(TextView)findViewById(R.id.request_code);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                postData();

            }
        });
    }



    private void postData() {

        user user=new user();
        user.setEmail(email_field.getText().toString());
        user.setPassword(password_filed.getText().toString());


        Log.i("response test","************************ before call"+user.getId());

        PostAppService postAppService= RetrofitInstance.getService();


        Call<user> call=postAppService.getResult(user);

        email_field.setText("");
        password_filed.setText("");


        call.enqueue(new Callback<com.namankhurpia.retrofit_post_app_udemy.model.user>() {
            @Override
            public void onResponse(Call<user> call, Response<user> response) {


                user returneduservalue=response.body();
                result_text_view.setText(returneduservalue.getId());

                Log.i("response test","************************  after call"+returneduservalue.getId());

                Toast.makeText(getApplicationContext(),"Successfully posted",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<user> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"Error 200",Toast.LENGTH_SHORT).show();
            }
        });



    }
}
