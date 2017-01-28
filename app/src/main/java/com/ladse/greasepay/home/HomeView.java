package com.ladse.greasepay.home;

import com.ladse.greasepay.home.model.RestaurantData;

import java.util.ArrayList;

/**
 * Created by pkatya on 1/27/17.
 */
public interface HomeView {
    void onHomeScreenResponseSuccess(ArrayList<RestaurantData>restaurantData);
    void onHomeScreenResponseError();
}
