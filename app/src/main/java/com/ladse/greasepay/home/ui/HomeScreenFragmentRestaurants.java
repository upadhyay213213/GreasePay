package com.ladse.greasepay.home.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ladse.greasepay.R;
import com.ladse.greasepay.constants.AppConstatnts;
import com.ladse.greasepay.home.model.RestaurantData;
import com.ladse.greasepay.home.utils.OutletFragmentAdapter;
import com.ladse.greasepay.home.utils.OutletListTouchListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeScreenFragmentRestaurants extends Fragment {
    private RecyclerView restaurantList;
    private ArrayList<RestaurantData> restaurantDataArrayList;


    public HomeScreenFragmentRestaurants() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_screen_fragment_restaurants, container, false);
        restaurantList = (RecyclerView) v.findViewById(R.id.home_fragment_restaurant_recyclerView);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            restaurantDataArrayList= (ArrayList<RestaurantData>) bundle.getSerializable(AppConstatnts.RESTAURANT_LIST);
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void onStart() {
        super.onStart();
        restaurantList.setHasFixedSize(true);
        OutletFragmentAdapter oFA = new OutletFragmentAdapter(restaurantDataArrayList, new OutletFragmentAdapter.OutletListChangeListener() {
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
    interface FragmentRestaurantHandler{
        void getRestaurantData();
    }
}
