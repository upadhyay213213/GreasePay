package com.ladse.greasepay.OutletDetails;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ladse.greasepay.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OutletDetailsFragmentEvents extends Fragment {


    public OutletDetailsFragmentEvents() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.outlet_details_tab_upcomingevents, container, false);
        return v;
    }

}
