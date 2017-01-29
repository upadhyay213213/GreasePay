package com.ladse.greasepay.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ladse.greasepay.OutletDetails.OutletDetailsFragmentAbout;
import com.ladse.greasepay.OutletDetails.OutletDetailsFragmentEvents;
import com.ladse.greasepay.OutletDetails.OutletDetailsFragmentGreasePay;

/**
 * Created by Shrivats on 1/27/2017.
 */

public class OutletDetailsScreenAdapter extends FragmentStatePagerAdapter {
    int numOfTabs;

    public OutletDetailsScreenAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new OutletDetailsFragmentGreasePay();
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
