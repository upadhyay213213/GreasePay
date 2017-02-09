package com.ladse.greasepay.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ladse.greasepay.R;
import com.ladse.greasepay.home.model.RestaurantData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Shrivats on 2/9/2017.
 */

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {

    private ArrayList<RestaurantData> restaurantDatas;
    private Context context;

    public FavoritesAdapter(ArrayList<RestaurantData> restaurantDatas, Context context) {
        this.restaurantDatas = restaurantDatas;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorites_adapter_view,
               parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mName.setText(restaurantDatas.get(position).getName());
        holder.mAddress.setText(restaurantDatas.get(position).getAddress());
        holder.mDistance.setText(restaurantDatas.get(position).getDistance());
        Picasso.with(context).load(restaurantDatas.get(position).getImageUrl()).into(holder.mBackgroundImage);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mBackgroundImage;
        TextView mName;
        TextView mAddress;
        TextView mDistance;
        ImageButton mFav;
        public ViewHolder(View itemView) {
            super(itemView);
            mBackgroundImage = (ImageView) itemView.findViewById(R.id
                    .favorites_adapter_restaurantImage);
            mName = (TextView) itemView.findViewById(R.id.favorites_adapter__outletName);
            mAddress = (TextView) itemView.findViewById(R.id.favorites_adapter_outletAddress);
            mDistance = (TextView) itemView.findViewById(R.id.favorites_adapter_outletDistance);
            mFav = (ImageButton) itemView.findViewById(R.id.favorites_adapter_button_fav);
        }
    }
}
