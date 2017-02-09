package com.ladse.greasepay.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ladse.greasepay.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PromocodeFragment extends Fragment {

    private RecyclerView promoRecycler;

    public PromocodeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_promocode, container, false);
        promoRecycler = (RecyclerView) v.findViewById(R.id.fragment_promocode_recycler);
        return v;
    }

}
