package com.ladse.greasepay.home;

import com.ladse.greasepay.home.model.RestaurantData;
import com.ladse.greasepay.home.model.RestaurantRequest;

import java.util.ArrayList;

/**
 * Created by pkatya on 1/27/17.
 */
public interface HomePresenter {

    void getRestaurantData(RestaurantRequest restaurantRequest);
    void onDestroy();
    ArrayList<RestaurantData> getClubBarData(ArrayList<RestaurantData>restaurantDatas);

}
