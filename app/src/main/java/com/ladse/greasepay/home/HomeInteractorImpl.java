package com.ladse.greasepay.home;

import com.ladse.greasepay.home.model.RestaurantRequest;
import com.ladse.greasepay.home.model.RestaurantResponse;
import com.ladse.greasepay.webclient_retro.ServerCall;
import com.ladse.greasepay.webclient_retro.ServiceGenerator;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pkatya on 1/27/17.
 */
public class HomeInteractorImpl implements HomeInteractor {

    @Override
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void getRestaurantData(String authToken, RestaurantRequest restaurantRequest, final onRestaurantResponseReceived onRestaurantResponseReceived) {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<RestaurantResponse> si = retrofitInterface.getRestaurantData(authToken, restaurantRequest);
        si.enqueue(new Callback<RestaurantResponse>() {
            @Override
            public void onResponse(Call<RestaurantResponse> call, Response<RestaurantResponse> response) {
                RestaurantResponse restaurantResponse = response.body();
                onRestaurantResponseReceived.onRestaurantResponseSuccess(restaurantResponse.getData());
            }

            @Override
            public void onFailure(Call<RestaurantResponse> call, Throwable t) {
                onRestaurantResponseReceived.onRestaurantResponseError();
            }
        });


    }

}
