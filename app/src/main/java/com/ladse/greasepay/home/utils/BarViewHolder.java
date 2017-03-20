package com.ladse.greasepay.home.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ladse.greasepay.R;
import com.ladse.greasepay.booking.AddRemoveFavoriteRequest;
import com.ladse.greasepay.common.AlertManager;
import com.ladse.greasepay.common.AppSharedPreference;
import com.ladse.greasepay.common.Model;
import com.ladse.greasepay.constants.AppConstatnts;
import com.ladse.greasepay.home.model.RestaurantData;
import com.ladse.greasepay.restaurantdetails.OutletDetailsScreen;
import com.ladse.greasepay.webclient_retro.ServerCall;
import com.ladse.greasepay.webclient_retro.ServiceGenerator;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private ImageView outletImage;
    private TextView outletName;
    private TextView outletAddress;
    private TextView outletDistance;
    private Button isFavorite;
    private Context mContext;
    private RestaurantData mRestaurantData;
    private String fvtAction;

    public BarViewHolder(View itemView, Context context) {
        super(itemView);
        outletImage = (ImageView) itemView.findViewById(R.id.home_fragment_outlet_outletImage);
        outletName = (TextView) itemView.findViewById(R.id.outlet_details_screen_outletName);
        outletAddress = (TextView) itemView.findViewById(R.id.outlet_details_screen_outletAddress);
        outletDistance = (TextView) itemView.findViewById(R.id.outlet_details_screen_outletDistance);
        isFavorite = (Button) itemView.findViewById(R.id.home_fragment_outlet_button_fav);
        itemView.setOnClickListener(this);
        isFavorite.setOnClickListener(this);
        this.mContext=context;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.home_fragment_outlet_button_fav) {
            AlertManager.showProgressDialog(mContext);
            if ((mRestaurantData.getFavorite())) {
                fvtAction = "remove";
                addRemoveFavorite(AppSharedPreference.getAuthToken(mContext), new AddRemoveFavoriteRequest(mRestaurantData.getRestaurantId(), fvtAction));
            } else {
                fvtAction = "add";
                addRemoveFavorite(AppSharedPreference.getAuthToken(mContext), new AddRemoveFavoriteRequest(mRestaurantData.getRestaurantId(), fvtAction));
            }
        } else {
            Bundle bundle = new Bundle();
            bundle.putSerializable(AppConstatnts.CLUB_DATA, mRestaurantData);
            Intent intent = new Intent(mContext, OutletDetailsScreen.class);
            intent.putExtra(AppConstatnts.BUNDLE, bundle);
            mContext.startActivity(intent);
        }
    }

    public void bindData(RestaurantData restaurantData) {
        mRestaurantData=restaurantData;
        outletName.setText(restaurantData.getName());
        outletAddress.setText(restaurantData.getAddress());
        outletDistance.setText((restaurantData.getDistance()) + "\n miles");
        Picasso.with(mContext).load(restaurantData.getImageUrl()).into(outletImage);
        if (restaurantData.getFavorite()) {
            isFavorite.setBackground(mContext.getDrawable(R.drawable.fav_icon));
        } else {
            isFavorite.setBackground(mContext.getDrawable(R.drawable.favorite_icon));

        }
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void addRemoveFavorite(String authToken, AddRemoveFavoriteRequest addRemoveFavoriteRequest) {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<Model> si = retrofitInterface.addRemoveFavorite(authToken, addRemoveFavoriteRequest);
        si.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if(response.body().getSuccess().equalsIgnoreCase(AppConstatnts.ServerResponseConstants.LOGIN_SIGNUP_SUCCESS)){
                    if(fvtAction.equalsIgnoreCase("remove")){
                       isFavorite.setBackgroundDrawable(mContext.getDrawable(R.drawable.favorite_icon));
                        mRestaurantData.setFavorite(false);
                    }else if(fvtAction.equalsIgnoreCase("add")){
                        isFavorite.setBackgroundDrawable(mContext.getDrawable(R.drawable.fav_icon));
                        mRestaurantData.setFavorite(true);
                    }
                }
                AlertManager.showErrorDialog(mContext, response.body().getMessage());
                AlertManager.disMissDialog();
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }

        });

    }
}
