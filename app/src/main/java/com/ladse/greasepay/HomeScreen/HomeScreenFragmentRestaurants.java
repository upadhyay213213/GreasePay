package com.ladse.greasepay.HomeScreen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ladse.greasepay.R;
import com.ladse.greasepay.model.OutletModel;
import com.ladse.greasepay.utils.OutletFragmentAdapter;
import com.ladse.greasepay.utils.OutletListTouchListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeScreenFragmentRestaurants extends Fragment {
    private RecyclerView restaurantList;
    private ArrayList<OutletModel> outletList;

    public HomeScreenFragmentRestaurants() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_screen_fragment_restaurants, container, false);
        restaurantList = (RecyclerView) v.findViewById(R.id.home_fragment_restaurant_recyclerView);
        outletList = new ArrayList<>();
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        restaurantList.setHasFixedSize(true);
        OutletFragmentAdapter oFA = new OutletFragmentAdapter(outletList, new OutletFragmentAdapter.OutletListChangeListener() {
            @Override
            public void OnFavChangeListener(boolean isFav) {
                //Fav icon toogle handling code goes here
            }
        });
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getContext());
        restaurantList.setLayoutManager(layout);
        restaurantList.setAdapter(oFA);
        restaurantList.addOnItemTouchListener(new OutletListTouchListener(getContext(), new OutletListTouchListener.OnOutletTouchListener() {
            @Override
            public void onItemClick(View v, int position) {
                //Handle outlet item click goes here
            }
        }));
    }
}
