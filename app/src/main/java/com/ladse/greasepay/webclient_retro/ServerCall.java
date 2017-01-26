package com.ladse.greasepay.webclient_retro;

import com.ladse.greasepay.constants.UrlConstants;
import com.ladse.greasepay.sinup.model.SinUpResponse;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ServerCall {

    @POST (UrlConstants.SIGN_UP_API)
    Call <SinUpResponse> sinUp( @Query("first_name") String firstName,@Query("last_name") String lastName,
                                @Query("email") String email,@Query("password") String password);



}
