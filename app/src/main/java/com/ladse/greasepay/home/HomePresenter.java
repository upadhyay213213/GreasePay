package com.ladse.greasepay.home;

import android.content.Context;

import com.ladse.greasepay.home.model.RestaurantData;
import com.ladse.greasepay.home.model.RestaurantRequest;

import java.util.ArrayList;

/**
 * Created by pkatya on 1/27/17.
 */
public interface HomePresenter {

    void getRestaurantData(Context context, RestaurantRequest restaurantRequest);
    void onDestroy();
    ArrayList<RestaurantData> getClubBarData(ArrayList<RestaurantData>restaurantDatas);

}
