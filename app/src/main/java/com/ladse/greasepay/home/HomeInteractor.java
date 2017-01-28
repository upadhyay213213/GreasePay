package com.ladse.greasepay.home;

import com.ladse.greasepay.home.model.RestaurantData;
import com.ladse.greasepay.home.model.RestaurantRequest;

import java.util.ArrayList;

/**
 * Created by pkatya on 1/27/17.
 */
public interface HomeInteractor {

    interface onRestaurantResponseReceived{
        void onRestaurantResponseSuccess(ArrayList<RestaurantData>restaurantData);
        void onRestaurantResponseError();
    }

    void getRestaurantData(String authToken,RestaurantRequest restaurantRequest,onRestaurantResponseReceived onRestaurantResponseReceived);
}
