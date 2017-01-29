package com.ladse.greasepay.home;

import com.ladse.greasepay.common.AppSharedPreference;
import com.ladse.greasepay.home.model.RestaurantData;
import com.ladse.greasepay.home.model.RestaurantRequest;
import com.ladse.greasepay.home.ui.HomeScreenActivity;

import java.util.ArrayList;

/**
 * Created by pkatya on 1/27/17.
 */
public class HomePresenterImpl implements HomePresenter, HomeInteractor.onRestaurantResponseReceived {

    private HomeView homeView;
    private HomeInteractor homeInteractor;

    public HomePresenterImpl(HomeView homeView) {
        this.homeView = homeView;
        homeInteractor = new HomeInteractorImpl();
    }

    @Override
    public void getRestaurantData(RestaurantRequest restaurantRequest) {
        homeInteractor.getRestaurantData(AppSharedPreference.getAuthToken((HomeScreenActivity) homeView), restaurantRequest, this);

    }

    @Override
    public void onDestroy() {
        homeView=null;
    }

    @Override
    public void onRestaurantResponseSuccess(ArrayList<RestaurantData> restaurantData) {
        homeView.onHomeScreenResponseSuccess(restaurantData);
    }

    @Override
    public void onRestaurantResponseError() {
        homeView.onHomeScreenResponseError();

    }
}
