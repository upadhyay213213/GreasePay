package com.ladse.greasepay.webclient_retro;

import com.ladse.greasepay.promocode.checkpromocode.model.CheckPromoCodeRequest;
import com.ladse.greasepay.promocode.checkpromocode.model.CheckPromoCodeResponse;
import com.ladse.greasepay.upcomingevents.EventRequest;
import com.ladse.greasepay.upcomingevents.EventResponse;
import com.ladse.greasepay.constants.AppConstatnts;
import com.ladse.greasepay.constants.UrlConstants;
import com.ladse.greasepay.home.model.RestaurantRequest;
import com.ladse.greasepay.home.model.RestaurantResponse;
import com.ladse.greasepay.login.LoginRequest;
import com.ladse.greasepay.sinup.SignUpRequest;
import com.ladse.greasepay.sinup.model.LoginSinUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface ServerCall {


    @Headers( "Content-Type: application/json" )
    @POST (UrlConstants.SIGN_UP_API)
    Call<LoginSinUpResponse>  sinUp(@Body SignUpRequest jsonBody );

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.LOGIN_API)
    Call<LoginSinUpResponse> login(@Body LoginRequest jsonBody);

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.RESTAURANT_SEARCH)
    Call<RestaurantResponse> getRestaurantData(@Header(AppConstatnts.ApiHeader.AUTHORIZATION_HEADER) String authToken, @Body RestaurantRequest jsonBody);

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.UPCOMING_EVENTS)
    Call<EventResponse> getUpComingEventsData(@Header(AppConstatnts.ApiHeader.AUTHORIZATION_HEADER) String authToken, @Body EventRequest jsonBody);

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.CHECK_PROMO_CODE)
    Call<CheckPromoCodeResponse> checkPromoCode(@Header(AppConstatnts.ApiHeader.AUTHORIZATION_HEADER) String authToken, @Body CheckPromoCodeRequest jsonBody);
}
