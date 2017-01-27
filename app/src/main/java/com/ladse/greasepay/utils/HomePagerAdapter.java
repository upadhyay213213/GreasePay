package com.ladse.greasepay.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ladse.greasepay.HomeScreen.HomeScreenFragmentBarsClubs;
import com.ladse.greasepay.HomeScreen.HomeScreenFragmentRestaurants;

/**
 * Created by Shrivats on 1/25/2017.
 */

public class HomePagerAdapter extends FragmentStatePagerAdapter {
    private int numOfTabs;

    public HomePagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeScreenFragmentBarsClubs();
            case 1:
                return new HomeScreenFragmentRestaurants();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
