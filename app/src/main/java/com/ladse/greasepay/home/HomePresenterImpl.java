package com.ladse.greasepay.home;

import android.content.Context;

import com.ladse.greasepay.common.AlertManager;
import com.ladse.greasepay.common.AppSharedPreference;
import com.ladse.greasepay.constants.AppConstatnts;
import com.ladse.greasepay.home.model.RestaurantData;
import com.ladse.greasepay.home.model.RestaurantRequest;

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
    public void getRestaurantData(Context context, RestaurantRequest restaurantRequest) {
        AlertManager.showProgressDialog((Context) homeView);
        homeInteractor.getRestaurantData(AppSharedPreference.getAuthToken(context), restaurantRequest, this);

    }

    @Override
    public void onDestroy() {
        homeView=null;
    }

    @Override
    public ArrayList<RestaurantData> getClubBarData(ArrayList<RestaurantData> restaurantDatas) {
        return getClubList(restaurantDatas);
    }

    @Override
    public void onRestaurantResponseSuccess(ArrayList<RestaurantData> restaurantData) {
        homeView.onHomeScreenResponseSuccess(restaurantData);
        AlertManager.disMissDialog();
    }

    @Override
    public void onRestaurantResponseError() {
        homeView.onHomeScreenResponseError();
        AlertManager.disMissDialog();

    }

    public ArrayList<RestaurantData> getClubList(ArrayList<RestaurantData>restaurantDatas){
        ArrayList<RestaurantData>restaurantDataArrayList=new ArrayList<>();
        for (int i = 0; i <restaurantDatas.size() ; i++) {
           if(restaurantDatas.get(i).getBarType().equalsIgnoreCase(AppConstatnts.CLUB_BAR_TYPE)){
               restaurantDataArrayList.add(restaurantDatas.get(i));
           }
        }
        return restaurantDataArrayList;

    }
}
