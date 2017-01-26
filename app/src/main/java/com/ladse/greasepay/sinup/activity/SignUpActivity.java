package com.ladse.greasepay.sinup.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ladse.greasepay.R;
import com.ladse.greasepay.constants.UrlConstants;
import com.ladse.greasepay.sinup.model.SinUpResponse;
import com.ladse.greasepay.webclient_retro.ServerCall;
import com.ladse.greasepay.webclient_retro.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    private ServerCall retrofitInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        retrofitInterface = ServiceGenerator.getRestService(UrlConstants.BASE_URL);
        Call<SinUpResponse> si=retrofitInterface.sinUp("Nandan","U","Test@gmail.com","Password");
        si.enqueue(new Callback<SinUpResponse>() {
            @Override
            public void onResponse(Call<SinUpResponse> call, Response<SinUpResponse> response) {
                SinUpResponse sinUpResponse=response.body();
                Log.v("SinUpResponse",response.body().toString());
                if(sinUpResponse.getSuccess().equalsIgnoreCase("")){
                    //startNextActivity
                }else{
                    //show alert.
                }

            }

            @Override
            public void onFailure(Call<SinUpResponse> call, Throwable t) {

            }
        });

    }


}
