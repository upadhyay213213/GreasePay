package com.ladse.greasepay.OutletDetails.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ladse.greasepay.OutletDetails.OutletDetailsFragmentAbout;
import com.ladse.greasepay.OutletDetails.OutletDetailsFragmentEvents;
import com.ladse.greasepay.OutletDetails.OutletDetailsFragmentGreasePay;
import com.ladse.greasepay.constants.AppConstatnts;
import com.ladse.greasepay.home.model.RestaurantData;

/**
 * Created by Shrivats on 1/27/2017.
 */

public class OutletDetailsScreenAdapter extends FragmentStatePagerAdapter {
    int numOfTabs;
    private RestaurantData restaurantData;

    public OutletDetailsScreenAdapter(FragmentManager fm, int numOfTabs, RestaurantData restaurantData) {
        super(fm);
        this.numOfTabs = numOfTabs;
        this.restaurantData=restaurantData;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                OutletDetailsFragmentGreasePay outletDetailsFragmentGreasePay=new OutletDetailsFragmentGreasePay();
                Bundle bundle=new Bundle();
                bundle.putSerializable(AppConstatnts.CLUB_DATA,restaurantData);
                outletDetailsFragmentGreasePay.setArguments(bundle);
                return outletDetailsFragmentGreasePay;
            case 1:
                return new OutletDetailsFragmentEvents();
            case 2:
                return new OutletDetailsFragmentAbout();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
