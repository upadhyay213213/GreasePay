package com.ladse.greasepay.webclient_retro;

import com.ladse.greasepay.constants.AppConstatnts;
import com.ladse.greasepay.constants.UrlConstants;
import com.ladse.greasepay.login.LoginRequest;
import com.ladse.greasepay.sinup.SignUpRequest;
import com.ladse.greasepay.sinup.model.LoginSinUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface ServerCall {


    @Headers( "Content-Type: application/json" )
    @POST (UrlConstants.SIGN_UP_API)
    Call<LoginSinUpResponse>  sinUp(@Body SignUpRequest jsonBody );

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.LOGIN_API)
    Call<LoginSinUpResponse> login(@Body LoginRequest jsonBody);
}
