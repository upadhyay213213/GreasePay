package com.ladse.greasepay.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ladse.greasepay.R;
import com.ladse.greasepay.favorite.FavoriteViewholder;
import com.ladse.greasepay.home.model.RestaurantData;

import java.util.ArrayList;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoriteViewholder> {

    private ArrayList<RestaurantData> restaurantDatas;
    private Context context;

    public FavoritesAdapter(ArrayList<RestaurantData> restaurantDatas, Context context) {
        this.restaurantDatas = restaurantDatas;
        this.context = context;
    }

    @Override
    public FavoriteViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorites_adapter_view,
               parent, false);
        return new FavoriteViewholder(v,context);
    }

    @Override
    public void onBindViewHolder(FavoriteViewholder holder, int position) {
        holder.bindData(restaurantDatas.get(position));
    }


    @Override
    public int getItemCount() {
        return restaurantDatas.size();
    }

}
