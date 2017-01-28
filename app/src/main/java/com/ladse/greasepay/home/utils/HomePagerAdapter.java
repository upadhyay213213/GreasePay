package com.ladse.greasepay.home.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ladse.greasepay.constants.AppConstatnts;
import com.ladse.greasepay.home.model.RestaurantData;
import com.ladse.greasepay.home.ui.HomeScreenFragmentBarsClubs;
import com.ladse.greasepay.home.ui.HomeScreenFragmentRestaurants;

import java.util.ArrayList;

/**
 * Created by Shrivats on 1/25/2017.
 */

public class HomePagerAdapter extends FragmentStatePagerAdapter {
    private int numOfTabs;
private ArrayList<RestaurantData>restaurantDataArrayList;

    public HomePagerAdapter(FragmentManager fm, int numOfTabs, ArrayList<RestaurantData> restaurantDatas) {
        super(fm);
        this.numOfTabs = numOfTabs;
        this.restaurantDataArrayList=restaurantDatas;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                HomeScreenFragmentBarsClubs homeScreenFragmentBarsClubs=new HomeScreenFragmentBarsClubs();
                Bundle bundle=new Bundle();
                bundle.putSerializable(AppConstatnts.RESTAURANT_LIST,restaurantDataArrayList);
                homeScreenFragmentBarsClubs.setArguments(bundle);
                return homeScreenFragmentBarsClubs;
            case 1:
                HomeScreenFragmentRestaurants homeScreenFragmentRestaurants=new HomeScreenFragmentRestaurants();
                Bundle bundle1=new Bundle();
                bundle1.putSerializable(AppConstatnts.RESTAURANT_LIST,restaurantDataArrayList);
                homeScreenFragmentRestaurants.setArguments(bundle1);
                return homeScreenFragmentRestaurants;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
