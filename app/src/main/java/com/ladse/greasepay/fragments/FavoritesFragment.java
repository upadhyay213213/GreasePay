package com.ladse.greasepay.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ladse.greasepay.R;
import com.ladse.greasepay.common.AlertManager;
import com.ladse.greasepay.common.AppSharedPreference;
import com.ladse.greasepay.home.model.RestaurantData;
import com.ladse.greasepay.home.model.RestaurantRequest;
import com.ladse.greasepay.home.model.RestaurantResponse;
import com.ladse.greasepay.utils.FavoritesAdapter;
import com.ladse.greasepay.webclient_retro.ServerCall;
import com.ladse.greasepay.webclient_retro.ServiceGenerator;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment {

    private RecyclerView mFavRecycler;
    private ArrayList<RestaurantData> restaurantDatas;
    private RestaurantRequest request;
    public FavoritesFragment() {
        // Required empty public constructor
        request = new RestaurantRequest();

        //todo set latitude and longitude for favorite list
        request.setLatitude("98.25689");
        request.setLongitude("-99.5874");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_favorites, container, false);
        mFavRecycler = (RecyclerView) v.findViewById(R.id.fragment_favorite_recycler);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        getFavoriteData(AppSharedPreference.getAuthToken(getActivity()), request);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void getFavoriteData(String authToken, RestaurantRequest restaurantRequest) {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<RestaurantResponse> si = retrofitInterface.getFavorite(authToken, restaurantRequest);
        si.enqueue(new Callback<RestaurantResponse>() {
            @Override
            public void onResponse(Call<RestaurantResponse> call, Response<RestaurantResponse> response) {
                RestaurantResponse restaurantResponse = response.body();
                    initAdapter(restaurantResponse.getData());
            }

            @Override
            public void onFailure(Call<RestaurantResponse> call, Throwable t) {
                AlertManager.showErrorDialog(getActivity(), "Can't fetch " +
                        "favorites");
            }
        });
    }
    private void initAdapter(ArrayList<RestaurantData> responseData){
        FavoritesAdapter adapter = new FavoritesAdapter(responseData, getActivity());
        mFavRecycler.setAdapter(adapter);
    }

}
