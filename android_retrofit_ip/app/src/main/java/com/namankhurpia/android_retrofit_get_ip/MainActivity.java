package com.namankhurpia.android_retrofit_get_ip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.namankhurpia.android_retrofit_get_ip.model.Ip;
import com.namankhurpia.android_retrofit_get_ip.remote.ipService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView txt;
    ipService mipService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mipService=Common.getipservice();

        btn=(Button)findViewById(R.id.button_ip);
        txt=(TextView)findViewById(R.id.text_ip);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getipAddress();
            }
        });

    }

    public void getipAddress() {
        mipService.getIp().enqueue(new Callback<Ip>() {
            @Override
            public void onResponse(Call<Ip> call, Response<Ip> response) {
                txt.setText(response.body().getIp());
            }

            @Override
            public void onFailure(Call<Ip> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"LOL ERROR",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
